package adventofcode2021.day3.binarydiagnostic;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode2021.day3.binarydiagnostic.BinaryDiagnostic.readBits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BinaryDiagnosticTests {
    private static final String DIAGNOSTIC_FILE = "data/day3/diagnostic.txt";

    @Test
    public void shouldCountBits() {
        final var diagnostic =
                new BinaryDiagnostic(
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
        final var diagnostic = new BinaryDiagnostic(readBits(DIAGNOSTIC_FILE));
        assertThat(diagnostic.getGamma() * diagnostic.getEpsilon(), is(equalTo(841526)));
    }
}