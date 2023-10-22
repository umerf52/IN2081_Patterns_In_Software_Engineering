package de.tum.in.ase.pse;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements ConnectionInterface {

	// TODO: Implement the SchoolProxy
    private Set<String> denylistedHosts;
    private URL redirectPage;
    private Set<Integer> teacherIDs;
    private boolean authorized;
    private NetworkConnection networkConnection;

    public SchoolProxy(Set<String> denylistedHosts, URL redirectPage, Set<Integer> teacherIDs) {
        this.denylistedHosts = denylistedHosts;
        this.redirectPage = redirectPage;
        this.teacherIDs = teacherIDs;
        this.authorized = false;
        this.networkConnection = new NetworkConnection();
    }

    public void connect(URL url) {
        if (authorized) {
            networkConnection.connect(url);
            return;
        }
        for (String denylistedHost : denylistedHosts) {
            if (url.getHost().equals(denylistedHost)) {
                System.err.printf("Connection to '%s' was rejected!%n", url);
                System.out.printf("Redirecting to '%s'", redirectPage);
                networkConnection.connect(redirectPage);
                return;
            }
        }
        networkConnection.connect(url);
    }
    public void disconnect() {
        networkConnection.disconnect();
    }
    public boolean isConnected() {
        return networkConnection.isConnected();
    }
    public void login(int teacherID) {
        if (teacherIDs.contains(teacherID)) {
            authorized = true;
        }
    }
    public void logout() {
        authorized = false;
    }
}
