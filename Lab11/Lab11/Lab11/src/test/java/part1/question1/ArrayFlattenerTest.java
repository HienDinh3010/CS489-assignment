package part1.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayFlattenerTest {

    @Test
    public void testFlattenArray_ValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        assertArrayEquals(expected, ArrayFlattener.flattenArray(input));
    }

    @Test
    public void testFlattenArray_NullInput() {
        int[][] input = null;
        int[] expected = {};
        assertArrayEquals(expected, ArrayFlattener.flattenArray(input));
    }
}