package adventofcode2021.day3.binarydiagnostic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;
import static java.util.Arrays.copyOf;

public class GammaEpsilon {
    private final List<Integer> values;
    private final int[] bitCounts;
    private final int gamma;
    private final int epsilon;

    public GammaEpsilon(final List<Integer> values) {
        this.values = values;
        this.bitCounts = countBits();

        // Compute gamma and epsilon.
        var m = 1;
        var gamma = 0;
        var epsilon = 0;
        final var mid = values.size() / 2;
        for (var bitCount : bitCounts) {
            if (bitCount >= mid) gamma += m;
            else epsilon += m;
            m <<= 1;
        }
        this.gamma = gamma;
        this.epsilon = epsilon;
    }

    public int[] getBitCounts() {
        return bitCounts;
    }

    public int getGamma() {
        return gamma;
    }

    public int getEpsilon() {
        return epsilon;
    }

    private int[] countBits() {
        var counts = new int[0];
        for (final var value : values) {
            for (int i = 0, r = value; r != 0; i++, r >>= 1) {
                if ((r & 1) == 1) {
                    if (counts.length <= i) {
                        counts = copyOf(counts, i + 1);
                    }
                    counts[i]++;
                }
            }
        }
        return counts;
    }
}