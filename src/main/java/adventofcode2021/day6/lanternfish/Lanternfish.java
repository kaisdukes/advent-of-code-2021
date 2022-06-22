package adventofcode2021.day6.lanternfish;

import java.util.List;

public class Lanternfish {

    public static void getNextDay(final List<Integer> timers) {
        final var n = timers.size();
        for (var i = 0; i < n; i++) {
            final var timer = timers.get(i);
            if (timer == 0) {
                timers.set(i, 6);
                timers.add(8);
            } else {
                timers.set(i, timer - 1);
            }
        }
    }
}