import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] items = { 2, 8, 7, 1, 3, 5, 6, 4 };
        quickSort(items);
        System.out.println(Arrays.toString(items));
    }

    public static void quickSort(int[] items) {
        quickSort(items, 0, items.length - 1);
    }

    private static void quickSort(int[] items, int p, int r) {
        if (p >= r)
            return;

        int q = partition(items, p, r);
        quickSort(items, p, q - 1);
        quickSort(items, q + 1, r);
    }

    private static int partition(int[] items, int p, int r) {
        int x = items[r];
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (items[j] > x)
                continue;

            swap(items, ++i, j);
        }

        swap(items, ++i, r);

        return i;
    }

    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}