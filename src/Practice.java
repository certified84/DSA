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
        List<Integer> teamA = new ArrayList<>();
        teamA.add(4);
        teamA.add(4);
        teamA.add(1);
        teamA.add(3);
//        System.out.println(birthdayCakeCandles(teamA));
    }

    static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int tallest = 0, count = 1;
        // Find the tallest and count in one loop O(n)
        for (int i = 0; i < candles.size(); i++) {
            if (candles.get(i) > tallest) {
                tallest = candles.get(i);
                continue;
            }
            if (candles.get(i) == tallest)
                count++;
        }
        return count;
    }

    static String breakPalindrome(String palindromeStr) {
        // Write your code here

        // Overall Time complexity O(n)

        System.out.println(palindromeStr);

        if (palindromeStr.length() == 1)
            return "IMPOSSIBLE";

        // step to check if all characters are 'a'
        boolean allA = true;
        for (int i = 0; i < palindromeStr.length(); i++) {
            if (palindromeStr.charAt(i) != 'a') {
                allA = false;
                break;
            }
        }
        if (allA)
            return "IMPOSSIBLE";

        // Step to handle modification of palindromeStr using StringBuilder
        StringBuilder builder = new StringBuilder();
        int check = 0;
        for (int i = 0; i < palindromeStr.length(); i++) {
            if (check < 1 && palindromeStr.charAt(i) != 'a') {
                check++;
                builder.append('a');
                continue;
            }
            builder.append(palindromeStr.charAt(i));
        }
        return builder.toString();
    }

    static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();

//        convert teamA to an array and sort
        int[] arrA = new int[teamA.size()];
        for (int i = 0; i < teamA.size(); i++) {
            arrA[i] = teamA.get(i);
        }
        Arrays.sort(arrA);

        for (int i = 0; i < teamB.size(); i++) {
            int end = arrA.length - 1, count = 0;
            while (end >= 0) {
                if (arrA[end] <= teamB.get(i)) {
                    count += end + 1;
                    break;
                }
                end--;
            }
            ans.add(count);
        }
        return ans;
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

    static int[] twoSum(int[] nums, int target) {
//        Brute Force. Time complexity O(n^n)
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target)
//                    return new int[]{i, j};
//            }
//        }
//         Optimized using hashmap. Time complexity O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//             At position i, the next value that sums up to
//             the target will be target - nums[i]
            int expected = target - nums[i];
//             At the begining, the HashMap is empty.
//             If the HashMap doesn't contain a key
//             of the expected element i.e. element that
//             should give the target when summed with the
//             current element nums[i], add the current element
//             to the HashMap with the element as the key, and it's
//             index as the value. This is because we are concerned
//             with returning the index of the two elements that sums
//             up to the target and not the element itself.
            if (!map.containsKey(expected))
                map.put(nums[i], i);
//             Else, the HashMap contains the expected value as a key
//             which means we've found our answer. Hence, return the
//             value (i.e. index) of the expected element in the HashMap
//             and the index of the current element.
            else return new int[]{map.get(expected), i};
        }

//         Something has to be returned in the end. But it is guaranteed that
//         this piece of code will not run since nums has exactly one solution.
        return new int[]{0, 0};
    }

    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                break;
            }
            map.put(s.charAt(i), i);
            builder.append(s.charAt(i));
        }
        return builder.length();
    }

    static boolean lint(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' || s.charAt(i) != ')')
                continue;
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.peek() == '(')
                    stack.pop();
                else return false;
            }
        }
        return true;
    }
}