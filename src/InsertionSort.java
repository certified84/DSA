import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        swapSort(new int[]{5, 3, 4, 1, 2});
    }

    static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
//            Loop to handle the shifting
            while (j >= 0 && arr[j] > current) {
//                Shift all elements greater than the current element to the right
//                by copying the element at arr[j] to arr[j+1] and decrementing j.
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swapSort(int[] arr) {
//        Outer loop handles the passes
        for (int i = 0; i < arr.length - 1; i++) {
//            Inner loop handles the swapping by comparing the current element with the previous element
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
