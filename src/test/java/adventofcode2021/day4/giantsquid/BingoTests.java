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

    @Test
    public void shouldFindLastWinningBoardForExampleFile() throws IOException {
        assertThat(playForLastWinningBoard(EXAMPLE_FILE), is(equalTo(1924)));
    }

    @Test
    public void shouldFindLastWinningBoardForBingoFile() throws IOException {
        assertThat(playForLastWinningBoard(BINGO_FILE), is(equalTo(23541)));
    }

    private static int play(final String path) throws IOException {
        final var bingoData = new BingoData(path);
        final var bingo = new Bingo(bingoData);
        return bingo.play();
    }

    private static int playForLastWinningBoard(final String path) throws IOException {
        final var bingoData = new BingoData(path);
        final var bingo = new Bingo(bingoData);
        return bingo.lastWinningBoard();
    }
}