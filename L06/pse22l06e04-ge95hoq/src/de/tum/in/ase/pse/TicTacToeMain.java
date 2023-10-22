package de.tum.in.ase.pse;

public final class TicTacToeMain {
    private TicTacToeMain() {

    }

    public static void main(String[] args) {
        // This is a workaround for a known issue when starting JavaFX applications
        TicTacToeGame.startApp(args);
    }
}
