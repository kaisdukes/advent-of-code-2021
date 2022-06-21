package adventofcode2021.day4.giantsquid;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BingoTests {
    private static final String EXAMPLE_FILE = "data/day4/example.txt";
    private static final String BINGO_FILE = "data/day4/bingo.txt";

    @Test
    public void shouldPlayExampleFile() throws IOException {
        assertThat(play(EXAMPLE_FILE), is(equalTo(4512)));
    }

    @Test
    public void shouldPlayBingoFile() throws IOException {
        assertThat(play(BINGO_FILE), is(equalTo(63424)));
    }

    private static int play(final String path) throws IOException {
        final var bingoData = new BingoData(path);
        final var bingo = new Bingo(bingoData);
        final var pair = bingo.play();
        final var value = pair.getFirst();
        final var board = pair.getSecond();
        return value * board.getScore();
    }
}