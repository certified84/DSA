import java.lang.reflect.Array;
import java.util.*;

public class Practice {
    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < 26; i++) {
//            char ch = (char) ('a' + i);
//            builder.append(ch);
//        }
//        System.out.println(builder);
//        System.out.println(builder.reverse());
//        System.out.println(builder);
//        reverse(120);
//        System.out.println(Arrays.toString(commonChars(new String[]{"cool", "lock", "cook"}).toArray()));
        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}};
        int target = 43;
        System.out.println(searchMatrix(matrix, target));
    }

    static void balanced(String name) {
        int lCount = 0, rCount = 0;
        StringBuilder builder = new StringBuilder(name);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == 'L')
                lCount++;
            else
                rCount++;
        }
    }

    static List<String> commonChars(String[] words) {
        List<String> commonChars = new ArrayList<>();
        StringBuilder[] wordBuilders = new StringBuilder[words.length];
        for (int i = 0; i < words.length; i++) {
            wordBuilders[i] = new StringBuilder(words[i]);
        }
        String word = words[0];
        for (int i = 0; i < word.length(); i++) {
            boolean contains = false;
            for (int j = 1; j < wordBuilders.length; j++) {
                contains = wordBuilders[j].toString().contains(word.charAt(i) + "");
                if (contains)
                    wordBuilders[j].deleteCharAt(wordBuilders[j].indexOf(word.charAt(i) + ""));
                else break;
            }
            if (contains)
                commonChars.add(word.charAt(i) + "");
        }
        return commonChars;
    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    //    reverse an integer
    static int reverseInt(int n) {
        long result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        return (int) result;
    }

    static void reverse(int x) {
        List<Integer> num = new ArrayList<>();
        while (x != 0) {
            num.add(x % 10);
            x /= 10;
        }
        System.out.println(Arrays.toString(num.toArray()));
    }

    static String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        for (char ch : address.toCharArray()) {
            builder.append(ch == '.' ? "[.]" : ch);
        }
        return builder.toString();
    }

    static boolean palindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < indices.length) {
            int j = indices[i];
            if (indices[i] != i) {
                int temp = indices[i];
                char ch = arr[i];
                indices[i] = indices[j];
                indices[j] = temp;
                arr[i] = arr[j];
                arr[j] = ch;
            } else
                i++;
        }
        return String.valueOf(arr);
    }

    static boolean searchMatrix(int[][] matrix, int target) {
//        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}};
        int row = 0, col = matrix[row].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            result[nums1.length + j] = nums2[j];
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        int n = result.length;
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;
        if (n % 2 == 0)
            return (result[mid] + result[mid + 1]) / 2.0;
        else
            return result[mid];
    }

    static void mergeSortedArray(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[i + j] = nums1[i];
                i++;
            } else {
                mergedArray[i + j] = nums2[j];
                j++;
            }
        }
        if (i < nums1.length)
            for (i = i; i < nums1.length; i++) {
                mergedArray[i + j] = nums1[i];
            }
        if (j < nums2.length)
            for (j = j; j < nums2.length; j++) {
                mergedArray[i + j] = nums2[j];
            }
        System.out.println(Arrays.toString(mergedArray));
    }
}
