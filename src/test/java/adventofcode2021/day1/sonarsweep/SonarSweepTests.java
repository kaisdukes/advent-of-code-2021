package adventofcode2021.day1.sonarsweep;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode2021.day1.sonarsweep.SonarSweep.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SonarSweepTests {
    private static final String REPORT_FILE = "data/day1/sonarsweep.txt";

    @Test
    public void shouldReturnDepthIncreases() {
        assertThat(
                depthIncreases(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)),
                is(equalTo(7)));
    }

    @Test
    public void shouldReturnDepthIncreasesForSonarSweepReport() throws IOException {
        assertThat(
                depthIncreases(readInts(REPORT_FILE)),
                is(equalTo(1387)));
    }

    @Test
    public void shouldReturnSlidingWindows() {
        assertThat(
                slidingWindows(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)),
                is(equalTo(List.of(607, 618, 618, 617, 647, 716, 769, 792))));
    }

    @Test
    public void shouldReturnDepthIncreasesOfSlidingWindows() {
        assertThat(
                depthIncreases(slidingWindows(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))),
                is(equalTo(5)));
    }

    @Test
    public void shouldReturnDepthIncreasesOfSlidingWindowsForSonarSweepReport() throws IOException {
        assertThat(
                depthIncreases(slidingWindows(readInts(REPORT_FILE))),
                is(equalTo(1362)));
    }
}