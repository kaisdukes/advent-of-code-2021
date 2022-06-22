package adventofcode2021.day6.lanternfish;

import java.util.Arrays;
import java.util.List;

public class Lanternfish {

    public static long countFish(final List<Integer> timers, final int days) {
        final var fish = new long[10];
        for (final var timer : timers) {
            fish[timer]++;
        }
        for (var i = 0; i < days; i++) {
            fish[7] += fish[0];
            fish[9] = fish[0];
            for (var j = 0; j < 9; j++) {
                fish[j] = fish[j + 1];
            }
            fish[9] = 0;
        }
        return Arrays.stream(fish).sum();
    }
}