import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        sort(new int[]{2, -32, 0, 78, 1});
    }

    static void sort(int[] arr) {
//        External loop handles the sorting
        for (int i = arr.length - 1; i >= 0; i--) {
//        This variable keeps track of the current largest element
            int largest = 0;
//            Internal loop handles finding the largest element
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }
//            If i == largest, that means arr[i] is already sorted
            if (i == largest)
                continue;
//            Swap the largest element to its correct position.
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
