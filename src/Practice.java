import org.jetbrains.annotations.Contract;

import java.lang.reflect.Array;
import java.util.*;

public class Practice {
    public static void main(String[] args) {
        int n = 12;
    }

    static String primeTime(int num) {
        // code goes here

        // Overal time complexity: O(sqrt(num))

        if (num <= 2)
            return "true";

        // To reduce the search space, we iterate from i = 2 to sqrt(num)
        // Since every possible number that can divide num will be encountered
        // before and after sqrt(num) e.g 2 * 16 = 32 and 16 * 2 = 32.

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return "false";
        }

        return "true";
    }

//    static boolean prime(int n) {
//        boolean isPrime = true;
//        for (int i = 2; i < n; i++) {
//            if (n % i == 0)
//                return false;
//        }
//        return isPrime;
//    }

    static String equivalentKeypresses(String[] strArr) {
        // code goes here

        // Overall time complexity: O(n)

        StringBuilder first = new StringBuilder(strArr[0]);
        StringBuilder second = new StringBuilder(strArr[1]);

        boolean isBackspace = true;
        while (isBackspace) {
            if (first.charAt(0) == '-' && first.charAt(1) == 'B') {
                first.deleteCharAt(0).deleteCharAt(0);
                continue;
            }
            isBackspace = false;
        }

        isBackspace = true;
        while (isBackspace) {
            if (second.charAt(0) == '-' && second.charAt(1) == 'B') {
                second.deleteCharAt(0).deleteCharAt(0);
                continue;
            }
            isBackspace = false;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == 'B' && first.charAt(i - 1) == '-')
                first.replace(i - 4, i + 1, "");
        }

        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) == 'B' && second.charAt(i - 1) == '-')
                second.replace(i - 4, i + 1, "");
        }

        return String.valueOf(first.toString().equals(second.toString()));
    }

    static long repeatedString(String s, long n) {
        // Write your code here
        if (s.equals("a"))
            return n;

        StringBuilder builder = new StringBuilder(s);
        while (builder.length() < n) {
            builder.append(s);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (builder.charAt(i) == 'a')
                count++;
        }

        System.out.println(builder);
        return count;
    }

    static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        // Overall TIme complexity O(nlogn)

        // Convert arr to an array and sort
        int[] arrA = new int[arr.size()];
        // O(n)
        for (int i = 0; i < arr.size(); i++) {
            arrA[i] = arr.get(i);
        }
        // O(nlogn)
        Arrays.sort(arrA);

        long max = 0L, min = 0L;
        // O(n)
        for (int i = 0; i < arrA.length; i++) {
            if (i == 0) {
                min += arrA[i];
                continue;
            }
            if (i == arrA.length - 1) {
                max += arrA[i];
                continue;
            }
            min += arrA[i];
            max += arrA[i];
        }
        System.out.println(min + " " + max);
    }

    static String timeConversion(String s) {
        // Write your code here
        System.out.println(Integer.MAX_VALUE);
        StringBuilder builder = new StringBuilder(s);
        String[] strs = s.split(":");
        int hh = Integer.parseInt(strs[0]);
        if (strs[2].contains("PM") && hh < 12) {
            hh += 12;
            builder.replace(0, 2, String.valueOf(hh));
        } else if (strs[2].contains("AM") && hh == 12) {
            builder.replace(0, 2, "00");
        }
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        System.out.println(s);
        return builder.toString();
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        while (x1 <= x2) {
            x1 += v1;
            x2 += v2;
        }
        System.out.println(x1);
        System.out.println(x2);
        if (x1 - v1 == x2 - v2)
            return "YES";
        else return "NO";
    }


    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    static boolean threeSum(int[] arr) {
        // code goes here
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                int expected = arr[0] - current - arr[j];
                if (!map.containsKey(expected)) {
//                    map.put(arr[i], i);
                    map.put(arr[j], j);
                } else return true;
            }
        }
        return false;
    }

    static String letterCount(String str) {
        int larges = 0, position = -1;
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            StringBuilder builder = new StringBuilder(strs[i]);

        }
        return position > -1 ? strs[position] : "-1";
    }

    static long countPairsII(int[] nums, int k) {
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long product = (long) nums[i] * nums[j];
                if (product % k == 0)
                    count++;
            }
        }
        return count;
    }

    static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        int applesCount = 0, orangesCount = 0;
        for (int i = 0; i < apples.size(); i++) {
            int position = apples.get(i) + a;
            if (position >= s && position <= t)
                applesCount++;
        }
        for (int j = 0; j < oranges.size(); j++) {
            int position = oranges.get(j) + b;
            if (position >= s && position <= t)
                orangesCount++;
        }
        System.out.println(applesCount + "\n" + orangesCount);
    }

    static int[] gradingStudents(int[] grades) {
        int[] roundedGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            int nextMultiple = ((grade - (grade % 5)) + 5);
            if (grade >= 38 && nextMultiple - grade < 3)
                roundedGrades[i] = nextMultiple;
            else
                roundedGrades[i] = grade;
        }
        return roundedGrades;
    }

    static boolean countPairs(int[] nums, int k) {
//        Arrays.sort(nums);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i))
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum % k == 0 && !map.containsKey(i) && !map.containsKey(j)) {
                    map.put(i, nums[i]);
                    map.put(j, nums[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
        return count == nums.length / 2;
    }

    static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int count = 0, start = 0, end = ar.size() - 1;
        while (start <= ar.size() - 2) {
            int sum = ar.get(start) + ar.get(end);
            if (sum % k == 0)
                count++;
            end--;
            if (end == start) {
                start++;
                end = ar.size() - 1;
            }
        }
        return count;
    }

    static int reverseNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }
        return reverse;
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

//    static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
//        // Write your code here
//        List<Integer> ans = new ArrayList<>();
//
////        convert teamA to an array and sort
//        int[] arrA = new int[teamA.size()];
//        for (int i = 0; i < teamA.size(); i++) {
//            arrA[i] = teamA.get(i);
//        }
//        Arrays.sort(arrA);
//
//        for (int i = 0; i < teamB.size(); i++) {
//            int end = arrA.length - 1, count = 0;
//            while (end >= 0) {
//                if (arrA[end] <= teamB.get(i)) {
//                    count += end + 1;
//                    break;
//                }
//                end--;
//            }
//            ans.add(count);
//        }
//        return ans;
//    }


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

//    static int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                break;
//            }
//            map.put(s.charAt(i), i);
//            builder.append(s.charAt(i));
//        }
//        return builder.length();
//    }

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

    static int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum * 2 > total + nums[j])
                break;
            if (sum * 2 == total + nums[j])
                return j;
        }
        return -1;
    }

    static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        String jit = "";
        for (int i = 0; i < s.length(); i++) {
            longest = Math.max(jit.length(), longest);
            if (jit.contains(s.charAt(i) + "")) {
                jit = "";
            }
            jit = jit.concat(s.charAt(i) + "");
        }
        System.out.println(jit);
        return Math.max(jit.length(), longest);
    }

    static boolean prime(int n) {
        if (n <= 1)
            return false;
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0)
                return false;
            c++;
        }
        return true;
    }

    static int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (prime(i))
                count++;
        }
        return count;
    }

    /* Bloomberg Hackerrank */
    static int minimumMoves(List<Integer> arr1, List<Integer> arr2) {
//        Question 1: Hackerrank minimum moves
        // Overall time complexity O(n^2)
        int moves = 0;
        for (int i = 0; i < arr1.size(); i++) {

            String first = arr1.get(i).toString();
            String second = arr2.get(i).toString();

            for (int j = 0; j < first.length(); j++) {

                if (first.charAt(j) == second.charAt(j))
                    continue;
                moves += Math.abs(first.charAt(j) - second.charAt(j));
            }
        }
        return moves;
    }

    static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
//        Question 2: Football scores
        Collections.sort(teamA);
        List<Integer> ans = new ArrayList<>();
        for (Integer integer : teamB) {
            int start = 0, end = teamA.size() - 1;
            // Binary search
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (teamA.get(mid) > integer)
                    end = mid - 1;
                else start = mid + 1;
            }
            ans.add(start);
        }
        return ans;
    }

    static void sieve(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (!primes[i])
                System.out.println(i + " is prime");
        }
    }

    static double sqrt(int n, int p) {
        int start = 0;
        int end = n;

        double root = 0.0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid * mid == n)
                return mid;

            if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                root = mid;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }

        return root;
    }

    static double newtonRaphson(int n) {
//        Newton Raphson method for finding square root of a number
        if (n <= 1) return n;
        double x = (double) n / 2;
        while (x * x > n) {
            x = (x + n / x) / 2;
        }
        return x;
    }

    static List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0)
                factors.add(i);
        }
        for (int i = (int) Math.sqrt(n); i <= n; i++) {
            if (n % i == 0)
                factors.add(i);
        }
        return factors;
    }
}