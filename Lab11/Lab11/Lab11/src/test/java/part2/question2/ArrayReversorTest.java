package part2.question2;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part1.question2.ArrayFlattenerService;
import part1.question2.ArrayReversor;

public class ArrayReversorTest {

    private ArrayFlattenerService arrayFlattenerService;

    private ArrayReversor arrayReversor;

    @BeforeEach
    void setUp() {
        this.arrayFlattenerService = new ArrayFlattenerService();
        this.arrayReversor = new ArrayReversor(this.arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        this.arrayFlattenerService = null;
    }

    @Test
    void test0() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] actual = arrayReversor.reverseArray(input);
        int[] expected = {9, 5, 4, 0, 3, 1};
        MatcherAssert.assertThat("Test fails: Result does not match", actual,
                CoreMatchers.is(CoreMatchers.equalTo(expected)));
    }

    @Test
    void test1() {
        int[][] input = null;
        int[] actual = arrayReversor.reverseArray(input);
        int[] expected = {};
        MatcherAssert.assertThat("Test fails: Result does not match", actual,
                CoreMatchers.is(CoreMatchers.equalTo(expected)));
    }
}
