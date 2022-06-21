package adventofcode2021.day3.binarydiagnostic;

import adventofcode2021.collections.Pair;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticReport {

    public static int getMaxBits(final List<Integer> values) {
        var max = 0;
        for (final var value : values) {
            var n = 0;
            var r = value;
            while (r != 0) {
                n++;
                r >>= 1;
            }
            if (n > max) max = n;
        }
        return max;
    }

    public static int[] getBitCounts(final List<Integer> values) {
        final var counts = new int[getMaxBits(values)];
        for (final var value : values) {
            for (int i = 0, r = value; r != 0; i++, r >>= 1) {
                if ((r & 1) == 1) {
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

    public static int getGasRating(final List<Integer> values, final boolean oxygen) {
        final var list = new ArrayList<>(values);
        final var maxBits = getMaxBits(list);
        var mask = 1 << (maxBits - 1);
        while (list.size() != 1) {
            var count0 = 0;
            var count1 = 0;
            for (final var value : list) {
                if ((value & mask) != 0) count1++;
                else count0++;
            }
            final var v = oxygen
                    ? count1 >= count0 ? mask : 0
                    : count1 < count0 ? mask : 0;
            final var m = mask;
            list.removeIf(x -> (x & m) != v);
            mask >>= 1;
        }
        return list.get(0);
    }
}