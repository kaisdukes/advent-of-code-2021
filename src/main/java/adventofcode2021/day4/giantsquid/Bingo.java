package adventofcode2021.day4.giantsquid;

public class Bingo {
    private final BingoData bingoData;

    public Bingo(final BingoData bingoData) {
        this.bingoData = bingoData;
    }

    public int play() {
        final var numbers = bingoData.getNumbers();
        final var boards = bingoData.getBoards();
        for (final var value : numbers) {
            for (final Board board : boards) {
                board.mark(value);
                if (board.isComplete()) {
                    return value * board.getScore();
                }
            }
        }
        throw new UnsupportedOperationException("No winning board.");
    }

    public int lastWinningBoard() {
        Board lastWinningBoard = null;
        int lastWinningNumber = 0;
        final var numbers = bingoData.getNumbers();
        final var boards = bingoData.getBoards();
        for (final var value : numbers) {
            for (var i = boards.size() - 1; i >= 0; i--) {
                final var board = boards.get(i);
                board.mark(value);
                if (board.isComplete()) {
                    boards.remove(i);
                    lastWinningBoard = board;
                    lastWinningNumber = value;
                }
            }
        }
        if (lastWinningBoard == null) {
            throw new UnsupportedOperationException("No last winning board.");
        }
        return lastWinningNumber * lastWinningBoard.getScore();
    }
}