package de.tum.in.ase.pse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame extends Application {

    private List<Button> buttonList;
    private Character[][] cells;

//    private static final Character Mark.X = 'X';
//    private static final Character Mark.O = 'O';
//    private static final Character Mark.E = 'E';

    private static final String IMAGE_X_PATH = "red.png";
    private static final String IMAGE_O_PATH = "lg.png";
    private final Image imagePC = new Image(IMAGE_X_PATH);
    private final Image imagePlayer = new Image(IMAGE_O_PATH);

    // row and column length
    private static final int ROW_COL_LENGTH = 3;
    // a line in which both Marks are present
    private static final int OBSOLETE_LINE = -1000;
    // used to evaluate the final Score of a line
    private static final int SCORE_VALUE = 10;

    private static final int PANE_SIZE = 600;
    private static final int BUTTON_SIZE = 200;

    private static final int[] WINNING_PATTERNS = {0b111000000, 0b000111000, 0b000000111, // rows
            0b100100100, 0b010010010, 0b001001001, // cols
            0b100010001, 0b001010100 // diagonals
    };

    public static void startApp(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primeStage) {
        primeStage.setTitle("TicTacToe");

        Scene scene = new Scene(createPane());
        primeStage.setScene(scene);
        primeStage.show();
    }

    private Pane createPane() {
        Pane pane = new Pane();

        pane.setPrefSize(PANE_SIZE, PANE_SIZE);
        cells = new Character[ROW_COL_LENGTH][ROW_COL_LENGTH];
        buttonList = new ArrayList<>();

        for (int i = 0; i < ROW_COL_LENGTH; i++) {
            for (int j = 0; j < ROW_COL_LENGTH; j++) {
                TicTacToeAction action = new TicTacToeAction(i, j);
                int row = i;
                int column = j;
                Button button = new Button();
                button.setLayoutY(row * BUTTON_SIZE);
                button.setLayoutX(column * BUTTON_SIZE);
                button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                button.setOnMouseClicked(event -> {
                    if (cells[row][column].equals(Mark.E)) {
                        button.setGraphic(new ImageView(imagePlayer));
                        action.makePlayerMove();
                    }
                });
                pane.getChildren().add(button);
                buttonList.add(button);
                cells[row][column] = new Cell(Mark.E);
            }
        }
        return pane;

    }

    public class TicTacToeAction {
        private final int column;
        private final int row;

        public TicTacToeAction(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void makePlayerMove() {
            cells[this.row][this.column] = Mark.O;
            userActionPerformed();
        }

        public void userActionPerformed() {
            if (isGameFinished()) {
                disableAllButtons();
            } else {
                aiPerformTurn();
            }
        }
    }

    public boolean isGameFinished() {
        boolean finished = false;
        if (hasWon(Mark.O)) {
            finished = true;
        }
        if (hasWon(Mark.X)) {
            finished = true;
        }
        int occupied = 0;
        for (int column = 0; column < ROW_COL_LENGTH; column++) {
            for (int row = 0; row < ROW_COL_LENGTH; row++) {
                if (!cells[row][column].equals(Mark.E)) {
                    occupied++;
                }
            }
        }
        if (occupied == ROW_COL_LENGTH * ROW_COL_LENGTH) {
            finished = true;
        }
        if (finished) {
            disableAllButtons();
        }
        return finished;
    }

    public void disableAllButtons() {
        for (Button button : buttonList) {
            button.setDisable(true);
        }
    }

    public void aiPerformTurn() {
        int[] bestMove = move();
        cells[bestMove[0]][bestMove[1]] = Mark.X;
        updateImagePC(bestMove[0], bestMove[1]);
        isGameFinished();
    }

    public int[] move() {
        // dont change the depth (the two in minimax)
        int[] result = minimax(2, Mark.X, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // depth, max-turn, alpha, beta
        return new int[] {result[1], result[2]}; // row, col
    }

    /**
     * Minimax (recursive) at level of depth for maximizing or minimizing player
     * with alpha-beta cut-off. Return int[3] of {score, row, col}
     */
    private int[] minimax(int depth, Character player, int alpha, int beta) {
        // Generate possible next moves in a list of int[2] of {row, col}.
        List<int[]> nextMoves = generateMoves();

        // pcCharacter is maximizing; while playerCharacter is minimizing
        int score;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0) {
            // Game-over or depth reached, evaluate score
            score = evaluate();
            return new int[] {score, bestRow, bestCol};
        } else {
            for (int[] move : nextMoves) {
                // try this move for the current "player"
                cells[move[0]][move[1]] = player;
                if (player.equals(Mark.X)) { // pcCharacter (computer) is maximizing player
                    score = minimax(depth - 1, Mark.O, alpha, beta)[0];
                    if (score > alpha) {
                        alpha = score;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else { // playerCharacter is minimizing player
                    score = minimax(depth - 1, Mark.X, alpha, beta)[0];
                    if (score < beta) {
                        beta = score;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }
                // undo move
                cells[move[0]][move[1]] = Mark.E;
                // cut-off
                if (alpha >= beta) {
                    break;
                }
            }
            return new int[] {player.equals(Mark.X) ? alpha : beta, bestRow, bestCol};
        }
    }

    private List<int[]> generateMoves() {
        List<int[]> nextMoves = new ArrayList<>(); // allocate List
        // If game-over, i.e., no next move
        if (hasWon(Mark.X) || hasWon(Mark.O)) {
            return nextMoves; // return empty list
        }

        // Search for empty cells and add to the List
        for (int row = 0; row < ROW_COL_LENGTH; ++row) {
            for (int col = 0; col < ROW_COL_LENGTH; ++col) {
                if (cells[row][col].equals(Mark.E)) {
                    nextMoves.add(new int[] {row, col});
                }
            }
        }
        return nextMoves;
    }

    private int evaluate() {
        int score = 0;
        // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
        score += evaluateLine(0, 0, 0, 1, 0, 2); // row 0
        score += evaluateLine(1, 0, 1, 1, 1, 2); // row 1
        score += evaluateLine(2, 0, 2, 1, 2, 2); // row 2
        score += evaluateLine(0, 0, 1, 0, 2, 0); // col 0
        score += evaluateLine(0, 1, 1, 1, 2, 1); // col 1
        score += evaluateLine(0, 2, 1, 2, 2, 2); // col 2
        score += evaluateLine(0, 0, 1, 1, 2, 2); // diagonal
        score += evaluateLine(0, 2, 1, 1, 2, 0); // alternate diagonal
        return score;
    }

    /**
     * The heuristic evaluation function for the given line of 3 cells
     * 
     * @return +100, +10, +1 for 3-, 2-, 1-in-a-line for computer.
     *         -100, -10, -1 for 3-, 2-, 1-in-a-line for opponent.
     *         0 otherwise
     */
    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
        int score;
        // First cell
        score = evaluateFirstCell(row1, col1);
        // Second cell
        score = evaluateSecondCell(row2, col2, score);
        if (score == OBSOLETE_LINE) {
            return 0;
        }
        // Third cell
        score = evaluateThirdCell(row3, col3, score);
        if (score == OBSOLETE_LINE) {
            return 0;
        }
        return score;
    }

    private int evaluateFirstCell(int row1, int col1) {
        // First cell
        if (cells[row1][col1].equals(Mark.X)) {
            return 1;
        }
        if (cells[row1][col1].equals(Mark.O)) {
            return -1;
        }
        return 0;
    }

    private int evaluateSecondCell(int row2, int col2, int score) {
        // Second cell
        if (cells[row2][col2].equals(Mark.X)) {
            if (score == 1) { // cell1 is pcCharacter
                return SCORE_VALUE;
            }
            if (score == -1) {
                return OBSOLETE_LINE; // cell1 is playerCharacter
            } else {
                return 1; // cell1 is empty
            }
        } else if (cells[row2][col2].equals(Mark.O)) {
            if (score == -1) { // cell1 is playerCharacter
                return -SCORE_VALUE;
            }
            if (score == 1) { // cell1 is pcCharacter
                return OBSOLETE_LINE;
            } else { // cell1 is empty
                return -1;
            }
        }
        return score;
    }

    private int evaluateThirdCell(int row3, int col3, int score) {
        // Third cell
        if (cells[row3][col3].equals(Mark.X)) {
            if (score > 0) { // cell1 and/or cell2 is pcCharacter
                return score * SCORE_VALUE;
            }
            if (score < 0) { // cell1 and/or cell2 is playerCharacter
                return OBSOLETE_LINE;
            } else { // cell1 and cell2 are empty
                return 1;
            }
        } else if (cells[row3][col3].equals(Mark.O)) {
            if (score < 0) { // cell1 and/or cell2 is playerCharacter
                return score * SCORE_VALUE;
            }
            if (score > 1) { // cell1 and/or cell2 is pcCharacter
                return OBSOLETE_LINE;
            } else { // cell1 and cell2 are empty
                return -1;
            }
        }
        return score;
    }

    /** Returns true if thePlayer wins */
    public boolean hasWon(Character thePlayer) {
        int pattern = 0b000000000; // 9-bit pattern for the 9 cells
        for (int row = 0; row < ROW_COL_LENGTH; ++row) {
            for (int col = 0; col < ROW_COL_LENGTH; ++col) {
                if (cells[row][col].equals(thePlayer)) {
                    pattern |= 1 << (row * ROW_COL_LENGTH + col);
                }
            }
        }
        for (int winningPattern : WINNING_PATTERNS) {
            if ((pattern & winningPattern) == winningPattern) {
                return true;
            }
        }
        return false;
    }

    public void updateImagePC(int row, int column) {
        for (Button button : buttonList) {
            if (button.getLayoutY() / BUTTON_SIZE == row && button.getLayoutX() / BUTTON_SIZE == column) {
                button.setGraphic(new ImageView(imagePC));
            }
        }
    }
}
