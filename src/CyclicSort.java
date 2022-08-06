import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        sortIncludingDuplicates(nums);
    }

    static void sort(int[] arr) {
//        My Solution
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
//            Increment i if arr[i] is at the correct position i.e arr[i] == i+1
            if (arr[i] == i + 1)
                i++;
//            Else swap arr[i] with arr[arr[i] - 1]
            else {
                int j = arr[i] - 1;
                swap(arr, i, j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void fromZeroSort(int[] arr) {
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
            if (arr[i] == arr.length)
                i++;
//            Increment i if arr[i] is at the correct position i.e arr[i] == i+1
            else if (arr[i] == i)
                i++;
//            Else swap arr[i] with arr[arr[i] - 1]
            else {
                int j = arr[i];
                swap(arr, i, j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void sortIncludingDuplicates(int[] arr) {
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
//            Correct position of current element
            int j = arr[i] - 1;
//            If current element is not equal to element at correct index,
//            Swap the elements. This check ignores duplicates.
            if (arr[i] != arr[j])
                swap(arr, i, j);
//            If the check above doesn't pass, that means current element
//            is already at correct position. Increment i
            else
                i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void kunalCycleSort(int[] arr) {
//        Kunal's solution
        int i = 0;
        while (i < arr.length) {
//            Correct index for current element
            int correct = arr[i] - 1;
//            If the current element is not equal to the element at the  correct index,
//            swap it with the element at the correct index
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
//            Else, the element is at its correct index. Increment i
            else i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int findMissing(int[] arr) {
        /* Since arr is between the range (0,arr.length), and only one number
         * is missing from arr, we could use find the expected sum of arr which
         * is the sum of all the elements assuming no element is missing and the
         * actual sum which is the sum of all the elements present in arr.
         * Subtracting the actual sum from the expected sum will give you the
         * missing number.
         */
        int expectedSum = 0, actualSum = 0;
        for (int i = 0; i <= arr.length; i++) {
            expectedSum += i;
//            Check to make sure index out of bound exception is avoided.
            if (i < arr.length)
                actualSum += arr[i];
        }
        System.out.println(expectedSum - actualSum);
        return expectedSum - actualSum;
    }
}
