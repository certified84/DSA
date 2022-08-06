public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18, 20, 22, 25, 27, 30, 32, 33, 34, 35, 36, 37, 40, 43, 45, 47, 49, 50, 51, 52, 54, 57, 60, 62, 64};
        int[] arr2 = {1, 2, 4, 5, 7, 9, 12, 20};
        int target = 30;
        int[] mountainArr = {1,2,3,5,6,4,3,2};
        System.out.println();
    }

    static int search(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            if (arr[start] == target)
                return start;

            if (arr[end] == target)
                return end;

            int mid = start + ((end - start) / 2);

            if (target < arr[mid]) end = mid - 1;
            else if (target > arr[mid]) start = mid + 1;
            else return mid;
        }
        return -1;
    }

    static int searchInfiniteArray(int[] arr, int target) {

        int start = 0;
        int end = 1;

//        Double the searchRange everytime O(log(n))
        while (target > arr[end]) {
            int temp = end + 1;
//            end = previous end + box range * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        while (start <= end) {

            int mid = start + ((end - start) / 2);

            if (target < arr[mid]) end = mid - 1;
            else if (target > arr[mid]) start = mid + 1;
            else return mid;
        }
        return -1;
    }
}
