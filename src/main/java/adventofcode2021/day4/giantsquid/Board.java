package adventofcode2021.day4.giantsquid;

public class Board {
    public static final int BOARD_SIZE = 5;

    private final int[][] values = new int[BOARD_SIZE][BOARD_SIZE];

    public int[][] getValues() {
        return values;
    }
}