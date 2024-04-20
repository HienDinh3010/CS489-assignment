package part1.question1;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {

    public static int[] flattenArray(int[][] nestedArray) {
        if (nestedArray == null) {
            return new int[0];
        }

        List<Integer> flattenedList = new ArrayList<>();
        for (int[] innerArray : nestedArray) {
            for (int num : innerArray) {
                flattenedList.add(num);
            }
        }

        int[] flattenedArray = new int[flattenedList.size()];
        for (int i = 0; i < flattenedList.size(); i++) {
            flattenedArray[i] = flattenedList.get(i);
        }

        return flattenedArray;
    }
}
