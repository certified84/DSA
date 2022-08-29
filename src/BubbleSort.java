import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1, 0, -1};
        BubbleSort sort = new BubbleSort();
        sort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    void sort(int[] array) {
//            Variable to check if the array is sorted and ignore other pass
        boolean isSorted;
//            Loop to handle the passes
        for (int i = 0; i < array.length; i++) {
//            Variable to check if the array is sorted and ignore other pass
//            If no swapping occurs, the array is sorted.
            isSorted = true;
//              Loop to handle the swapping
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
