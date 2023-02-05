import java.util.*;
import java.util.function.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] items = { 31, 41, 59, 26, 41, 58 };
        sort(items, true);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items, boolean descending) {
        BiFunction<Integer, Integer, Boolean> compare = descending
                ? (a, b) -> a > b
                : (a, b) -> a < b;

        for (int i = 1; i < items.length; i++) {
            int item = items[i];
            int j = i - 1;

            while (j >= 0 && compare.apply(item, items[j])) {
                items[j + 1] = items[j--];
            }

            items[j + 1] = item;
        }
    }
}
