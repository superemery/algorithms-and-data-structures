import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] items = { 31, 41, 59, 26, 41, 58 };
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items) {
        int s = 0;
        int e = items.length - 1;

        sort(items, s, e);
    }

    private static void sort(int[] items, int s, int e) {
        if (s >= e)
            return;

        int m = (s + e) / 2;
        sort(items, s, m);
        sort(items, m + 1, e);
        merge(items, s, m, e);
    }

    private static void merge(int[] items, int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;
        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            l[i] = items[s + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = items[m + i + 1];
        }

        l[l.length - 1] = Integer.MAX_VALUE;
        r[r.length - 1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = s; k <= e; k++) {
            if (l[i] <= r[j]) {
                items[k] = l[i++];
            } else {
                items[k] = r[j++];
            }
        }
    }
}
