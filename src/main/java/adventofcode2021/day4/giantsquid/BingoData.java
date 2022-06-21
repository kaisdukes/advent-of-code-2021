package adventofcode2021.day4.giantsquid;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static adventofcode2021.day4.giantsquid.Board.BOARD_SIZE;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static java.util.stream.Collectors.toList;

public class BingoData {
    private final List<Integer> numbers;
    private final List<Board> boards = new ArrayList<>();

    public BingoData(final String path) throws IOException {
        final var lines = readAllLines(Paths.get(path));

        numbers = Arrays
                .stream(lines.get(0).split(","))
                .map(Integer::parseInt)
                .collect(toList());

        final var boardCount = (lines.size() - 1) / (BOARD_SIZE + 1);
        var line = 2;
        for (var i = 0; i < boardCount; i++) {
            final var board = new Board();
            for (var j = 0; j < BOARD_SIZE; j++) {
                board.getValues()[j] = readRow(lines.get(line++));
            }
            boards.add(board);
            line++;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public static int[] readRow(final String text) {
        final var values = new int[BOARD_SIZE];
        for (var i = 0; i < BOARD_SIZE; i++) {
            var start = i * 3;
            final var end = start + 2;
            if (text.charAt(start) == ' ') start += 1;
            values[i] = parseInt(text.substring(start, end));
        }
        return values;
    }
}