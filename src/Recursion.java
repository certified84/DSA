import java.sql.Array;

public class Recursion {
    public static void main(String[] args) {
        int n = 14;
//        int[] sortedNumbers = {3, 7, 12, 18, 23, 29, 34, 41, 45, 52, 58, 63, 71, 85, 92};
//        System.out.println(binarySearch(sortedNumbers, 12, 0, sortedNumbers.length -1));
        nto1(100);
    }

    static void nto1(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        nto1(n-1);
        System.out.println(n);
    }

    static int numberOfSteps(int num) {
        int count = 0;
        if (num == 0)
            return 0;
        count++;
        if (num % 2 == 0)
            return count + numberOfSteps(num / 2);
        return count + numberOfSteps(num - 1);
    }

    static int noOfZeros(int n) {
        int count = 0;
        if (n == 0)
            return 0;
        if (n % 10 == 0)
            count++;
        return count + noOfZeros(n / 10);
    }

    static StringBuilder reverse(int n) {
        StringBuilder builder = new StringBuilder(String.valueOf(n % 10));
        if (n < 10)
            return new StringBuilder(String.valueOf(n));
        return builder.append(reverse(n / 10));
    }

    static int reverse(int n, int base) {
        if (n < 10)
            return n;
        return (n % 10) * base + reverse(n / 10, base / 10);
    }

    static int sumOfDigits(int n) {
        if (n < 10)
            return n;
        return (n % 10) + sumOfDigits(n / 10);
    }

    static int factorial(int n) {
        if (n < 10)
            return n;

        return n * factorial(n - 1);
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

    static int fibonacciFormula(int n) {
        return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
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

    static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix.length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] > target)
                column--;
            else
                row++;
        }
        return false;
    }
}
