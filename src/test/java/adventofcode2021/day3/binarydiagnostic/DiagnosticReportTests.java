package adventofcode2021.day3.binarydiagnostic;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DiagnosticReportTests {
    private static final String DIAGNOSTIC_FILE = "data/day3/diagnostic.txt";

    @Test
    public void shouldCountBits() {
        final var diagnostic =
                new DiagnosticReport(
                        List.of(
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
                                0b01010));

        assertThat(diagnostic.getBitCounts(), is(equalTo(new int[]{5, 7, 8, 5, 7})));
        assertThat(diagnostic.getGamma(), is(equalTo(22)));
        assertThat(diagnostic.getEpsilon(), is(equalTo(9)));
    }

    @Test
    public void shouldReadDiagnosticFile() throws IOException {
        final var diagnostic = new DiagnosticReport(parseDiagnosticsFile());
        assertThat(diagnostic.getGamma() * diagnostic.getEpsilon(), is(equalTo(841526)));
    }

    private static List<Integer> parseDiagnosticsFile() throws IOException {
        return readAllLines(Paths.get(DIAGNOSTIC_FILE))
                .stream()
                .map(x -> Integer.parseInt(x, 2))
                .collect(Collectors.toList());
    }
}