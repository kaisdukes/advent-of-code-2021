package adventofcode2021.day1.sonarsweep;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode2021.day1.sonarsweep.SonarSweep.depthIncreases;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SonarSweepTests {

    @Test
    public void shouldReturnDepthIncreases() {
        assertThat(
                depthIncreases(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)),
                is(equalTo(7)));
    }

    @Test
    public void shouldReturnDepthIncreasesForSonarSweepReport() throws IOException {
        assertThat(
                depthIncreases("data/day1/sonarsweep.txt"),
                is(equalTo(1387)));
    }
}