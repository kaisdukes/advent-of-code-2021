package adventofcode2021.day1.sonarsweep;

import java.util.ArrayList;
import java.util.List;

public class SonarSweep {

    public static int depthIncreases(final List<Integer> depths) {
        var count = 0;
        for (var i = 0; i < depths.size() - 1; i++) {
            if (depths.get(i + 1) > depths.get(i)) count++;
        }
        return count;
    }

    public static List<Integer> slidingWindows(final List<Integer> depths) {
        final var windows = new ArrayList<Integer>();
        var sum = depths.get(0) + depths.get(1) + depths.get(2);
        windows.add(sum);

        for (var i = 0; i < depths.size() - 3; i++) {
            sum += depths.get(i + 3) - depths.get(i);
            windows.add(sum);
        }
        return windows;
    }
}