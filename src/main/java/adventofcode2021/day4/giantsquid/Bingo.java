package adventofcode2021.day4.giantsquid;

import adventofcode2021.collections.Pair;

public class Bingo {
    private final BingoData bingoData;

    public Bingo(final BingoData bingoData) {
        this.bingoData = bingoData;
    }

    public Pair<Integer, Board> play() {
        final var numbers = bingoData.getNumbers();
        final var boards = bingoData.getBoards();
        for (final var value : numbers) {
            for (final Board board : boards) {
                board.mark(value);
                if (board.isComplete()) {
                    return new Pair<>(value, board);
                }
            }
        }
        throw new UnsupportedOperationException("No winning board.");
    }
}