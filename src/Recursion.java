public class Recursion {
    public static void main(String[] args) {
//        System.out.println(fibo(6));
        int[] arr = {-5, -3, -2, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = -4;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }

    static void print(int start, int end) {
        if (start > end)
            return;

        System.out.println(start);
        print(start + 1, end);
    }

    static int fibo(int n) {
        if (n < 2)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return binarySearch(arr, target, start, mid - 1);
        else
            return binarySearch(arr, target, mid + 1, end);
    }
}
