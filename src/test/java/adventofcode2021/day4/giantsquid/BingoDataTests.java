package adventofcode2021.day4.giantsquid;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode2021.day4.giantsquid.BingoData.readRow;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BingoDataTests {
    private static final String EXAMPLE_FILE = "data/day4/example.txt";

    @Test
    public void shouldReadRow() {
        assertThat(readRow("25 29 78 57 69"), is(equalTo(new int[]{25, 29, 78, 57, 69})));
        assertThat(readRow("47 51  7 21 82"), is(equalTo(new int[]{47, 51, 7, 21, 82})));
        assertThat(readRow(" 9 37 48 71 91"), is(equalTo(new int[]{9, 37, 48, 71, 91})));
    }

    @Test
    public void shouldReadExampleFile() throws IOException {
        final var bingoData = new BingoData(EXAMPLE_FILE);

        assertThat(
                bingoData.getNumbers(),
                is(equalTo(List.of(
                        7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16,
                        13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1))));

        final var boards = bingoData.getBoards();
        assertThat(boards.size(), is(equalTo(3)));

        assertThat(boards.get(0).getValues(), is(equalTo(
                new int[][]{
                        {22, 13, 17, 11, 0},
                        {8, 2, 23, 4, 24},
                        {21, 9, 14, 16, 7},
                        {6, 10, 3, 18, 5},
                        {1, 12, 20, 15, 19}}
        )));

        assertThat(boards.get(1).getValues(), is(equalTo(
                new int[][]{
                        {3, 15, 0, 2, 22},
                        {9, 18, 13, 17, 5},
                        {19, 8, 7, 25, 23},
                        {20, 11, 10, 24, 4},
                        {14, 21, 16, 12, 6}}
        )));

        assertThat(boards.get(2).getValues(), is(equalTo(
                new int[][]{
                        {14, 21, 17, 24, 4},
                        {10, 16, 15, 9, 19},
                        {18, 8, 23, 26, 20},
                        {22, 11, 13, 6, 5},
                        {2, 0, 12, 3, 7}}
        )));
    }
}