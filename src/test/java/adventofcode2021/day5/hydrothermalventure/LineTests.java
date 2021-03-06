package adventofcode2021.day5.hydrothermalventure;

import org.junit.Test;

import static adventofcode2021.day5.hydrothermalventure.Line.parseLine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LineTests {

    @Test
    public void shouldDetermineIfLineIsHorizontal() {
        assertThat(
                new Line(0, 9, 5, 9).isHorizontal(),
                is(equalTo(true)));

        assertThat(
                new Line(2, 2, 2, 1).isHorizontal(),
                is(equalTo(false)));
    }

    @Test
    public void shouldDetermineIfLineIsVertical() {
        assertThat(
                new Line(0, 9, 5, 9).isVertical(),
                is(equalTo(false)));

        assertThat(
                new Line(2, 2, 2, 1).isVertical(),
                is(equalTo(true)));
    }

    @Test
    public void shouldParseLine() {
        assertThat(
                parseLine("0,9 -> 5,9"),
                is(equalTo(new Line(0, 9, 5, 9))));

        assertThat(
                parseLine("323,858 -> 859,322"),
                is(equalTo(new Line(323, 858, 859, 322))));
    }

    @Test
    public void shouldFormatLine() {
        assertThat(
                new Line(0, 9, 5, 9).toString(),
                is(equalTo("0,9 -> 5,9")));

        assertThat(
                new Line(323, 858, 859, 322).toString(),
                is(equalTo("323,858 -> 859,322")));
    }
}