package adventofcode2021.day3.binarydiagnostic;

import java.util.List;

public class BinaryDiagnostic {

    public static int[] countBits(List<Integer> values) {
        final var counts = new int[32];
        for (final var value : values) {
            for (int i = 0, r = value; r != 0; i++, r >>= 1) {
                if ((r & 1) == 1) {
                    counts[i]++;
                }
            }
        }
        return counts;
    }
}