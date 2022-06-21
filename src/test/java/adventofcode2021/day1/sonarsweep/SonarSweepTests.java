package adventofcode2021.day1.sonarsweep;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static adventofcode2021.day1.sonarsweep.SonarSweep.*;
import static java.nio.file.Files.readAllLines;
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
                depthIncreases(parseReportFile()),
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
                depthIncreases(slidingWindows(parseReportFile())),
                is(equalTo(1362)));
    }

    public static List<Integer> parseReportFile() throws IOException {
        return readAllLines(Paths.get(REPORT_FILE))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}