import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] items = { 5, 13, 2, 25, 7, 17, 20, 8, 4 };
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items) {
        buildMaxHeap(items);

        for (int i = items.length - 1; i >= 1; i--) {
            swap(items, i, 0);
            maxHeapify(items, i, 0);
        }
    }

    private static void buildMaxHeap(int[] items) {
        int firstInner = items.length / 2 - 1;

        for (int i = firstInner; i >= 0; i--) {
            maxHeapify(items, items.length, i);
        }
    }

    private static void maxHeapify(int[] items, int size, int index) {
        int l = index * 2 + 1;
        int r = index * 2 + 2;
        int largest = index;

        if (l < size && items[l] > items[largest]) {
            largest = l;
        }

        if (r < size && items[r] > items[largest]) {
            largest = r;
        }

        if (largest == index)
            return;

        swap(items, index, largest);
        maxHeapify(items, size, largest);
    }

    private static void swap(int[] items, int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
