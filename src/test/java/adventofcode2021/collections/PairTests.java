package adventofcode2021.collections;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PairTests {

    @Test
    public void shouldGetPairComponents() {
        final var pair = new Pair<>("a", 1);
        assertThat(pair.getFirst(), is(equalTo("a")));
        assertThat(pair.getSecond(), is(equalTo(1)));
    }
}