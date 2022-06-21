package adventofcode2021.day5.hydrothermalventure;

import org.junit.Test;

import java.io.IOException;

import static adventofcode2021.day5.hydrothermalventure.Line.parseFile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class VentsTests {
    private static final String EXAMPLE_FILE = "data/day5/example.txt";
    private static final String VENTS_FILE = "data/day5/vents.txt";

    @Test
    public void shouldCountPointsForHorizontalAndVerticalExampleLines() throws IOException {
        assertThat(
                countPointsForHorizontalAndVerticalLines(10, EXAMPLE_FILE),
                is(equalTo(5)));
    }

    @Test
    public void shouldCountPointsForExampleLines() throws IOException {
        assertThat(
                countPointsForLines(10, EXAMPLE_FILE),
                is(equalTo(12)));
    }

    @Test
    public void shouldCountPointsForHorizontalAndVerticalVentLines() throws IOException {
        assertThat(
                countPointsForHorizontalAndVerticalLines(1000, VENTS_FILE),
                is(equalTo(7085)));
    }

    @Test
    public void shouldCountPointsForVentLines() throws IOException {
        assertThat(
                countPointsForLines(1000, VENTS_FILE),
                is(equalTo(20271)));
    }

    private static int countPointsForHorizontalAndVerticalLines(
            final int dimension, final String path) throws IOException {

        final var vents = new Vents(dimension, dimension);
        final var lines = parseFile(path);
        for (final var line : lines) {
            if (line.isHorizontal() || line.isVertical()) {
                vents.add(line);
            }
        }
        return vents.countMultipleVentPoints();
    }

    private static int countPointsForLines(final int dimension, final String path) throws IOException {
        final var vents = new Vents(dimension, dimension);
        final var lines = parseFile(path);
        for (final var line : lines) {
            vents.add(line);
        }
        return vents.countMultipleVentPoints();
    }
}