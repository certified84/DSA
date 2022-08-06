public class Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18, 20, 22, 25, 27, 30, 32, 33, 34, 35, 36, 37, 40, 43, 45, 47, 49, 50};
        int[] arr2 = {1, 2, 4, 5, 7, 9, 12, 20};
        int target = 3;
        System.out.println(findFloor(arr2, target));
    }

    static int findFloor(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            if (arr[start] == target)
                return start;

            if (arr[end] == target)
                return end;

            int mid = end - ((end - start) / 2);

            if (target < arr[mid]) end = mid - 1;
            else if (target > arr[mid]) start = mid + 1;
            else return mid;
        }
        return end;
    }
}
