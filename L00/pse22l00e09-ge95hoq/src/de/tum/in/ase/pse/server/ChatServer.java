package de.tum.in.ase.pse.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChatServer {

    public static final int PORT = 1337;
    private final List<ClientThread> clientThreads = Collections.synchronizedList(new ArrayList<>());

    public void connect(Socket socket) {
        try {
            ClientThread clientThread = new ClientThread(socket);
            clientThreads.add(clientThread);
            clientThread.sendMessage("Welcome to chat! Your client ID is: " + clientThread.hashCode());
            System.out.println("New client connected. ID: " + clientThread.hashCode());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public void disconnect(ClientThread client) {
        broadcast(client, "Client " + this.hashCode() + " logged out.");
        clientThreads.remove(client);
    }

    public void broadcast(ClientThread activeClient, String message) {
        synchronized (clientThreads) {
            for (ClientThread client : clientThreads) {
                if (!client.equals(activeClient)) {
	                client.sendMessage(message);
                }
            }
        }
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on " + PORT);
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                connect(socket);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ChatServer().start();
    }

    private class ClientThread extends Thread {
        private static final String LOGOUT_MESSAGE = ".logout";
        private final Socket clientSocket;
        private final BufferedReader input;
        private final PrintWriter output;

        ClientThread(Socket socket) throws IOException {
            this.clientSocket = Objects.requireNonNull(socket);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
            output = new PrintWriter(clientSocket.getOutputStream(), true, StandardCharsets.UTF_8);
            super.start();
        }

        public void readMessage(String message) {
            String messageWithClientId = "Client " + this.hashCode() + ": " + message;
            System.out.println(messageWithClientId);
            System.out.println("Broadcasting...");
            broadcast(this, messageWithClientId);
        }

        public void sendMessage(String message) {
            output.println(message);
        }

        public void close() {
            sendMessage("Good bye " + this.hashCode());
            try {
                interrupt();
                clientSocket.close();
                disconnect(this);
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while (!interrupted()) {
                    message = input.readLine();
                    if (message == null || LOGOUT_MESSAGE.equals(message)) {
                        close();
                        break;
                    }
                    readMessage(message);
                }
            } catch (IOException e) {
                System.out.print(e.getMessage());
            } finally {
                close();
            }
        }

    }

}
