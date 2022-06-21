package adventofcode2021.day3.binarydiagnostic;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static adventofcode2021.day3.binarydiagnostic.DiagnosticReport.*;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DiagnosticReportTests {
    private static final String DIAGNOSTIC_FILE = "data/day3/diagnostic.txt";
    private static final List<Integer> TEST_VALUES = List.of(
            0b00100,
            0b11110,
            0b10110,
            0b10111,
            0b10101,
            0b01111,
            0b00111,
            0b11100,
            0b10000,
            0b11001,
            0b00010,
            0b01010);

    @Test
    public void shouldGetMaxBits() {
        assertThat(getMaxBits(TEST_VALUES), is(equalTo(5)));
    }

    @Test
    public void shouldCountBits() {
        assertThat(getBitCounts(TEST_VALUES), is(equalTo(new int[]{5, 7, 8, 5, 7})));
    }

    @Test
    public void shouldGetGammaAndEpsilon() {
        final var pair = getGammaAndEpsilon(TEST_VALUES);
        assertThat(pair.getFirst(), is(equalTo(22)));
        assertThat(pair.getSecond(), is(equalTo(9)));
    }

    @Test
    public void shouldGetGammaAndEpsilonFromDiagnosticFile() throws IOException {
        final var pair = getGammaAndEpsilon(parseDiagnosticsFile());
        assertThat(pair.getFirst() * pair.getSecond(), is(equalTo(841526)));
    }

    @Test
    public void shouldGetOxygenRating() {
        assertThat(getGasRating(TEST_VALUES, true), is(23));
    }

    @Test
    public void shouldGetCO2Rating() {
        assertThat(getGasRating(TEST_VALUES, false), is(10));
    }

    @Test
    public void shouldGetOxygenAndCO2RatingsFromDiagnosticFile() throws IOException {
        final var values = parseDiagnosticsFile();
        final var pair = getGammaAndEpsilon(parseDiagnosticsFile());
        assertThat(
                getGasRating(values, true) * getGasRating(values, false),
                is(equalTo(4790390)));
    }

    private static List<Integer> parseDiagnosticsFile() throws IOException {
        return readAllLines(Paths.get(DIAGNOSTIC_FILE))
                .stream()
                .map(x -> parseInt(x, 2))
                .collect(Collectors.toList());
    }
}