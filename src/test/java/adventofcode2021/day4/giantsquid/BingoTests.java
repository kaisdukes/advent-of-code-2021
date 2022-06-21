package adventofcode2021.day4.giantsquid;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BingoTests {
    private static final String EXAMPLE_FILE = "data/day4/example.txt";

    @Test
    public void shouldPlayExampleFile() throws IOException {
        final var bingoData = new BingoData(EXAMPLE_FILE);
        final var bingo = new Bingo(bingoData);
        final var pair = bingo.play();
        final var value = pair.getFirst();
        final var board = pair.getSecond();
        assertThat(value * board.getScore(), is(equalTo(4512)));
    }
}