package adventofcode2021.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Io {

    public static List<Integer> readInts(final String path) throws IOException {
        return Files
                .readAllLines(Paths.get(path))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}