package adventofcode2021.day2.dive;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AimTests {
    private static final String COMMAND_FILE = "data/day2/commands.txt";

    @Test
    public void shouldExecuteCommands() {
        final var aim = new Aim();
        aim.execute(List.of(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"));

        assertThat(aim.getPosition(), is(equalTo(15)));
        assertThat(aim.getDepth(), is(equalTo(60)));
        assertThat(aim.getAim(), is(equalTo(10)));
    }

    @Test
    public void shouldExecuteCommandFile() throws IOException {
        final var aim = new Aim();
        aim.execute(readAllLines(Paths.get(COMMAND_FILE)));
        assertThat(aim.getPosition() * aim.getDepth(), is(equalTo(1942068080)));
    }
}