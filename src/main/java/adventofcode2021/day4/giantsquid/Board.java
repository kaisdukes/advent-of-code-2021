package adventofcode2021.day4.giantsquid;

public class Board {
    public static final int BOARD_SIZE = 5;

    private final int[][] values = new int[BOARD_SIZE][BOARD_SIZE];
    private final boolean[][] marks = new boolean[BOARD_SIZE][BOARD_SIZE];
    private boolean isComplete;

    public int[][] getValues() {
        return values;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void mark(final int value) {
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                if (values[i][j] == value) {
                    marks[i][j] = true;
                    checkCompleteRow(i);
                    checkCompleteColumn(j);
                }
            }
        }
    }

    public int getScore() {
        var sum = 0;
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                if (!marks[i][j]) {
                    sum += values[i][j];
                }
            }
        }
        return sum;
    }

    private void checkCompleteRow(final int rowIndex) {
        for (var i = 0; i < BOARD_SIZE; i++) {
            if (!marks[rowIndex][i]) return;
        }
        isComplete = true;
    }

    private void checkCompleteColumn(final int columnIndex) {
        for (var i = 0; i < BOARD_SIZE; i++) {
            if (!marks[i][columnIndex]) return;
        }
        isComplete = true;
    }
}