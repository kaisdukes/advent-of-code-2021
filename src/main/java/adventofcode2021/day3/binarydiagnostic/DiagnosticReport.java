package adventofcode2021.day3.binarydiagnostic;

import adventofcode2021.collections.Pair;

import java.util.List;

import static java.util.Arrays.copyOf;

public class DiagnosticReport {

    public static int[] getBitCounts(final List<Integer> values) {
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

    public static Pair<Integer, Integer> getGammaAndEpsilon(final List<Integer> values) {
        final var bitCounts = getBitCounts(values);
        var m = 1;
        var gamma = 0;
        var epsilon = 0;
        final var mid = values.size() / 2;
        for (var bitCount : bitCounts) {
            if (bitCount >= mid) gamma += m;
            else epsilon += m;
            m <<= 1;
        }
        return new Pair<>(gamma, epsilon);
    }
}