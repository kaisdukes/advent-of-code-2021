package adventofcode2021.day1.sonarsweep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SonarSweep {

    public static int depthIncreases(final List<Integer> depths) {
        var count = 0;
        for (var i = 0; i < depths.size() - 1; i++) {
            if (depths.get(i + 1) > depths.get(i)) count++;
        }
        return count;
    }

    public static int depthIncreases(final String path) throws IOException {
        final var depths =
                Files
                        .readAllLines(Paths.get(path))
                        .stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        return depthIncreases(depths);
    }
}