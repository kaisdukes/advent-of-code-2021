package adventofcode2021.day1.sonarsweep;

import java.util.List;

public class SonarSweep {

    public static int depthIncreases(final List<Integer> depths) {
        var count = 0;
        for (var i = 0; i < depths.size() - 1; i++) {
            if (depths.get(i + 1) > depths.get(i)) count++;
        }
        return count;
    }
}