package adventofcode2021.day6.lanternfish;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static adventofcode2021.day6.lanternfish.Lanternfish.getNextDay;
import static java.util.stream.Collectors.toCollection;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LanternfishTests {
    private static final String LANTERNFISH_FILE = "data/day6/lanternfish.txt";

    @Test
    public void shouldCountFishForExampleData() {
        final var timers = new ArrayList<>(List.of(3, 4, 3, 1, 2));
        for (var i = 0; i < 80; i++) {
            getNextDay(timers);
        }
        assertThat(timers.size(), is(equalTo(5934)));
    }

    @Test
    public void shouldCountFish() throws IOException {
        final var timers = Arrays.stream(
                        Files.readString(Paths.get(LANTERNFISH_FILE)).split(","))
                .map(Integer::parseInt).collect(toCollection(ArrayList::new));

        for (var i = 0; i < 80; i++) {
            getNextDay(timers);
        }
        assertThat(timers.size(), is(equalTo(386640)));
    }
}