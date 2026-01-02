import exceptions.StackException;
import heap.CustomMaxHeap;
import linkedlist.ListNode;
import stackQueue.CustomStack;

import java.util.*;

public class Practice {
    public static void main(String[] args) throws StackException {
        String s = "a1a3b4c1d2e3a2b1";
        System.out.println(betterCompression(s));
    }

    public static String betterCompression(String s) {
        StringBuilder betterCompressed = new StringBuilder();

        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new LinkedHashMap<>();

        int num = 0, multiplier = 1;
        boolean exist = false;
        char prev = '!';

        for (int i = 0; i < s.length(); i++) {

            if (Character.isAlphabetic(s.charAt(i))) {

//                Get the current character
                char current = s.charAt(i);

//                Before processing the current char or resetting num and multiplier, update the value of prev
//                if (prev != '!') {
//                    map.put(prev, map.getOrDefault(prev, 0) + num);
//                }

//                Reset num and multiplier for the new char
                num = 0;
                multiplier = 1;

//                Start processing the current char
                exist = !set.add(s.charAt(i));

//                If the current character already exist, increase its value in the hashMap
                if (exist) {
                    prev = s.charAt(i);
                    continue;
                }
                else map.put(current, 0);

//                Reset num and multiplier
//                num = 0;
//                multiplier = 1;
            }

            if (Character.isDigit(s.charAt(i))) {
                num = (num * multiplier) + Integer.parseInt(s.charAt(i) + "");
                multiplier = multiplier * 10;
                int def = map.getOrDefault(prev, 0);
                int sum = def + num;
                map.put(prev, sum);
            }
        }

        Object[] keys = map.keySet().toArray();
        for (Object key : keys) {
            int value = map.get(key);
            betterCompressed.append(key).append(value);
        }

        return betterCompressed.toString();
    }

    public static List<String> preprocessDate(List<String> dates) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        List<String> ans = new ArrayList<>();

        for (String date : dates) {
            String[] split = date.split(" ");
            StringBuilder processedDate = new StringBuilder();
            processedDate.append(split[2]).append("-").append(months.get(split[1])).append("-");
            if (Character.isDigit(split[0].charAt(1)))
                processedDate.append(split[0].charAt(0)).append(split[0].charAt(1));
            else processedDate.append(0).append(split[0].charAt(0));
            ans.add(processedDate.toString());
        }

        return ans;
    }

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        Collections.sort(lengths);
        int maxProfit = 0;
        for (int i = 1; i <= lengths.get(lengths.size() - 1); i++) {
            int salePricePerRod = salePrice * i, profit = 0;
            for (int rodLength : lengths) {
                int uniformRods = Math.floorDiv(rodLength, i);
                if (uniformRods > 0) {
                    int extraCut = rodLength % i > 0 ? 1 : 0;
                    int totalCuts = (uniformRods - 1) + extraCut;
                    int costs = totalCuts * costPerCut;
                    int revenues = uniformRods * salePricePerRod;
                    if (revenues > costs)
                        profit += revenues - costs;
                }
            }
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }

    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        // Write your code here
        List<List<String>> ans = new ArrayList<>();
        for (String query : queries) {
            List<String> anagrams = new ArrayList<>();
            for (String word : words) {

                char[] queryChar = query.toCharArray();
                char[] wordChar = word.toCharArray();

                Arrays.sort(queryChar);
                Arrays.sort(wordChar);

                for (int i = 0; i < queryChar.length; i++) {
                    if (queryChar[i] != wordChar[i])
                        break;
                }

                String newQuery = Arrays.toString(queryChar);
                String newWord = Arrays.toString(wordChar);

                if (newWord.equals(newQuery))
                    anagrams.add(word);
            }
            Collections.sort(anagrams);
            if (!anagrams.isEmpty()) ans.add(anagrams);
        }
        return ans;
    }

//    private static boolean isAnagram(String s, String p) {
//        char[] sArr = s.toCharArray();
//        char[] pArr = p.toCharArray();
//
//        for (int i = 0; i < sArr.length; i++) {
//            if (sArr[i] != pArr[i])
//                return false;
//        }
//
//        return true;
//    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    static int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.remove();
        }
        return nums;
    }

    static int countOdds(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0)
                count++;
        }
        return 0;
    }

    static int search(int[] arr, int target) {
        return helper(arr, target, 0);
    }

    static int helper(int[] arr, int target, int i) {
        if (i == arr.length)
            return -1;
        if (arr[i] == target)
            return i;
        return helper(arr, target, ++i);
    }

    static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode current = reverseList(head.next);
        return current;
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int i = queue.size();
            while (i > 0) {
                TreeNode current = queue.remove();
                if (current != null) {
                    level.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
                i--;
            }
            if (!level.isEmpty())
                ans.add(level);
        }

        for (int i = 1; i < ans.size(); i += 2) {
            List<Integer> current = ans.get(i);
            int n = current.size();
            for (int j = 0; j < n / 2; j++) {
                int temp = current.get(j);
                current.set(j, current.get(n - 1 - j));
                current.set(n - 1 - j, temp);
            }
        }

        return ans;
    }

    static long distinctNames(String[] ideas) {
        Set<String> set = new HashSet<>(Arrays.asList(ideas));
        long ans = 0;
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                StringBuilder ideaA = new StringBuilder(ideas[i]), ideaB = new StringBuilder(ideas[j]);
                char temp = ideaA.charAt(0);
                ideaA.replace(0, 1, ideaB.charAt(0) + "");
                ideaB.replace(0, 1, temp + "");
                if (set.contains(ideaA.toString()) || set.contains(ideaB.toString()))
                    continue;
                ans += 2;
            }
        }
        return ans;
    }

    static int totalFruit(int[] fruits) {

        if (fruits.length <= 2)
            return fruits.length;

        Set<Integer> set = new HashSet<>();
        int totalFruit = 0, left = 0, right = 0;

        while (right < fruits.length) {
            set.add(fruits[right]);
            if (set.size() > 2) {
                left = right - 1;
                set = new HashSet<>();
                set.add(fruits[left]);
                set.add(fruits[right]);
            }
            totalFruit = Math.max(totalFruit, ++right - left);
        }

        return totalFruit;
    }

    static boolean isPalindrome(int x) {
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        System.out.println(builder);
        int left = 0, right = builder.length() - 1;
        while (left <= right) {
            if (builder.charAt(left) != builder.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static int[] shuffle(int[] nums, int n) {

        if (n <= 1)
            return nums;

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[i / 2];
        }

        for (int i = nums.length - 1; i > 0; i -= 2) {
            ans[i] = 8;
        }

        return ans;
    }

    static int lengthOfLongestSubstring(String s) {

        int lengthOfLongestSubstring = 0, left = 0, right = 1;

        while (right < s.length()) {
            String substring = s.substring(left, right);
            for (int i = 0; i < s.length(); i++) {
                if (!substring.contains(s.charAt(right) + ""))
                    break;
                left++;
                substring = s.substring(left, right);
            }
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, substring.length() + 1);
            right++;
        }

        return lengthOfLongestSubstring;
    }

    static List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int left = 0;
        for (int right = p.length() - 1; right < s.length(); right++) {

            boolean isEqual = false;
            for (int j = 0; j < p.length(); j++) {
                isEqual = Objects.equals(sMap.get(p.charAt(j)), pMap.get(p.charAt(j)));
                if (!isEqual)
                    break;
            }

            if (isEqual)
                ans.add(left);

            sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
            left++;

            if (right + 1 == s.length())
                break;
            sMap.put(s.charAt(right + 1), sMap.getOrDefault(s.charAt(right + 1), 0) + 1);
        }
        return ans;
    }

    static boolean checkInclusion(String s1, String s2) {

//        Find the frequency of all characters in s1
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {

            if (i + windowSize > s2.length())
                return false;
            String substring = s2.substring(i, i + windowSize);

//            Find the frequency of all characters in the substring
            Map<Character, Integer> map1 = new HashMap<>();
            for (int j = 0; j < substring.length(); j++) {
                map1.put(substring.charAt(j), map1.getOrDefault(substring.charAt(j), 0) + 1);
            }

//            Check if the frequency of characters are same in s1 and substring
            boolean isEqual = false;
            for (int j = 0; j < s1.length(); j++) {
                isEqual = Objects.equals(map.get(s1.charAt(j)), map1.get(s1.charAt(j)));
                if (!isEqual)
                    break;
            }

            if (isEqual)
                return true;
        }

        return false;
    }

    static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            for (int j = 0; j < current.length(); j++) {
                if (j == next.length())
                    return false;
                int currentPos = map.get(current.charAt(j));
                int nextPos = map.get(next.charAt(j));
                if (currentPos == nextPos)
                    continue;
                else if (nextPos < currentPos)
                    return false;
                else break;
            }
        }

        return true;
    }

    static String gcdOfStrings(String str1, String str2) {

        String smallest, largest, gcd;
        if (str1.length() > str2.length()) {
            smallest = str2;
            largest = str1;
        } else {
            smallest = str1;
            largest = str2;
        }

        StringBuilder builder = new StringBuilder(smallest);
        for (int i = builder.length() - 1; i >= 0; i--) {

            if (largest.length() % builder.length() != 0) {
                builder.deleteCharAt(i);
                continue;
            }

            int requiredLargestLength = largest.length() / builder.length();
            gcd = builder.toString();
            StringBuilder divisor = new StringBuilder();
            for (int j = 1; j <= requiredLargestLength; j++) {
                divisor.append(builder);
            }

            int requiredSmallestLength = smallest.length() / builder.length();
            StringBuilder divisor1 = new StringBuilder();
            for (int j = 1; j <= requiredSmallestLength; j++) {
                divisor1.append(builder);
            }
            if (divisor.toString().equals(largest) && divisor1.toString().equals(smallest))
                return gcd;

            builder.deleteCharAt(i);
        }
        return "";
    }

    static int countValidWords(String sentence) {
        int count = 0;
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.length() > 1 && (word.startsWith("-") || word.endsWith("-")) || word.equals(""))
                continue;
            if (isValid(word))
                count++;
        }
        return count;
    }

    static boolean isStack(String s) {
        Stack<Character> stack = new Stack<>();
        /* For this solution, when we encounter an opening parentheses,
         * we push the equivalent of its closing to the stack. If we
         * encounter a closing parentheses, we check if the character
         * at the top of the stack is same. If they are, the string is
         * still valid else it isn't*/
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != ch)
                return false;
        }
        return stack.isEmpty();
    }

    private static boolean isValid(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {

            char current = word.charAt(i);
            if (Character.isDigit(current))
                return false;

            else if (current == '-' && map.containsKey(current) && !Character.isLowerCase(word.charAt(i - 1)) && !Character.isLowerCase(word.charAt(i + 1))) {
                return false;
            } else if ((current == '!' || current == '.' || current == ',') && i != word.length() - 1)
                return false;

            else map.put(current, i);

        }
        return true;
    }

    public static void checkScope() {
        String i = "function scope";
        if (true) {
            i = "block scope";
            System.out.printf("Block Scope i is: %s%n", i);
        }
        System.out.println("Function scope i is: %s%n" + 2.5);
    }

    static int palindromic(String s) {
        long count = 0L;
        List<String> subsequences = possibleStrings(s);
        for (String subsequence : subsequences) {
            if (isPalindrome(subsequence))
                count++;
        }
        return (int) (count % (Math.pow(10, 9) + 7));
    }

    static List<String> possibleStrings(String s) {
        int n = s.length();
        List<String> subsequences = new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            StringBuilder subsequence = new StringBuilder();
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i)) != 0) {
                    subsequence.append(s.charAt(i));
                }
            }
            if (subsequence.length() == 5) {
                subsequences.add(subsequence.toString());
            }
        }
        return subsequences;
    }

    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left != right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static ListNode condence(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode tail = head;
        ListNode prev = head;
        while (tail != null) {
            if (!set.add(tail.val)) {
                prev.next = tail.next;
//                prev = prev.next;
                tail = prev.next;
                continue;
            }
            prev = tail;
            tail = tail.next;
        }
        prev.next = tail;
        return head;
    }

    static int buildRect(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            // value represents the number of times the number appears
            int value = map.get(key);
            if (value <= 1)
                continue;
            for (int key1 : map.keySet()) {
                int value1 = map.get(key1);
                if (value1 <= 1 || key == key1)
                    continue;
                int diff = key - key1;
                min = Math.min(min, Math.abs(diff));
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    static int checkLetters(String s) {

        if (s.length() < 3)
            return 3 - s.length();

        StringBuilder builder = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'b');
        map.put('b', 'c');
        map.put('c', 'a');

        Stack<Character> stack = new Stack<>();
        int i = 0;
        int count = 0;
        while (i < s.length()) {

            char current = s.charAt(i);

            if (stack.isEmpty()) {
                builder.append(current);
                stack.push(current);
                i++;
                continue;
            }

            char previous = stack.peek();
            char expected = map.get(previous);

            if (current != expected) {
                count++;
                builder.append(expected);
                stack.push(expected);
                continue;
            }

            builder.append(current);
            stack.push(current);
            i++;
        }
        System.out.println(builder);

        if (builder.charAt(0) != 'a') {
            count += builder.charAt(0) - 'a';
        }

//        if (builder.charAt(builder.length() - 1) != 'c') {
//            count += 'c' - builder.charAt(0);
//        }

        return count >= 0 ? count : -1;
    }

    static int solution(int[] array) {
        // Your solution goes here.
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        int first = sum / 2;
        int second = sum - first;
        return Math.abs(first - second);
    }

    static int findRows(int[] array) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : array) {
            if (stack.isEmpty()) {
                stack.push(num);
                count++;
                continue;
            }

            if (num > stack.peek()) {
                count++;
            }
            stack.push(num);
        }
        return count;
    }

    static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1)
                return i;
        }
        return -1;
    }

    static String primeTime(int num) {
        // code goes here

        // Overall time complexity: O(sqrt(num))

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

//    static boolean prime(int n) {
//        boolean isPrime = true;
//        for (int i = 2; i < n; i++) {
//            if (n % i == 0)
//                return false;
//        }
//        return isPrime;
//    }

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

    static boolean threeSum(int[] arr) {
        // code goes here
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                int expected = arr[0] - current - arr[j];
                if (!map.containsKey(expected)) {
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
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length + 0, nums2.length);
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

    static boolean lint(String s) throws StackException {
        CustomStack<Character> stack = new CustomStack<>(Character.class);
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
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

//    static int lengthOfLongestSubstring(String s) {
//        int longest = 0;
//        String jit = "";
//        for (int i = 0; i < s.length(); i++) {
//            longest = Math.max(jit.length(), longest);
//            if (jit.contains(s.charAt(i) + "")) {
//                jit = "";
//            }
//            jit = jit.concat(s.charAt(i) + "");
//        }
//        System.out.println(jit);
//        return Math.max(jit.length(), longest);
//    }

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

    /* RemoteBase Hackerrank test */
    static int maxDifference(List<Integer> px) {
        int maxDifference = -1, start = 0, end = 1;
//        for (int i = 0; i < px.size(); i++) {
//            for (int j = i + 1; j < px.size(); j++) {
//                int diff = px.get(j) - px.get(i);
//                maxDifference = Math.max(maxDifference, diff);
//            }
//        }
        while (end < px.size()) {
            int difference = px.get(end) - px.get(start);
            if (px.get(start) < px.get(end))
                maxDifference = Math.max(maxDifference, difference);
            else
                start = end;
            end++;
        }
        return maxDifference;
    }

    static String mergePalindromes(String s1, String s2) {
        s1 = buildPalindrome(s1);
        System.out.println(s1);
        s2 = buildPalindrome(s2);
        System.out.println(s2);
        return buildPalindrome(s1 + s2);
    }

    static String buildPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        int start = 0, end = s.length() - 1;
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && !map.containsKey(j) && !map.containsKey(i)) {
                    builder.replace(start, start + 1, String.valueOf(s.charAt(i)));
                    builder.replace(end, end + 1, String.valueOf(s.charAt(j)));
                    end--;
                    start++;
                    map.put(i, s.charAt(i));
                    map.put(j, s.charAt(j));
                    break;
                }
            }
        }
        return builder.toString();
    }

    static String armstrongNumber(int n) {
        // code here
        int temp = n, sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, 3);
            temp /= 10;
        }
        return sum == n ? "Yes" : "No";
    }

    static long factorial(int N) {
        // code here
        if (N == 0 || N == 1)
            return 1;
        return N * factorial(N - 1);
    }

    /* AlgoExpert Three Number Sum */
    static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int start = i + 1, end = array.length - 1;
            while (start < end) {
                int currentSum = array[i] + array[start] + array[end];
                if (currentSum == targetSum) {
                    Integer[] nums = new Integer[]{array[i], array[start], array[end]};
                    ans.add(nums);
                    start++;
                    end--;
                } else if (currentSum > targetSum) end--;
                else start++;
            }
        }
        return ans;
    }

    /* AlgoExpert Tournament Winner */
    static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        /* Problem says find the tournament winner
         * For every competition, there can either be a winner or loser.
         * A winner has 3 points per win and a loser 0 points.
         * The competitions are a list of competition. With each competition,
         * one team is at home and the other is away.
         * The results are a list of result corresponding to each competition
         * When result[i] == 1, that means the home team wins where home team
         * == competitions[i][0]. When result[i] == 0, that means the away team
         * wins where away team == competitions[i][0]
         * We can easily find the winner of the competition by putting each team
         * and their corresponding scores in a HashMap. Then find the team with
         * the highest score in the HashMap.*/

        // Write your code here.
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < results.size(); i++) {

            String homeTeam = competitions.get(i).get(0);
            String awayTeam = competitions.get(i).get(1);

            if (results.get(i) == 1) {
                map.put(homeTeam, map.getOrDefault(homeTeam, 0) + 3);
                map.put(awayTeam, map.getOrDefault(awayTeam, 0));
            } else {
                map.put(awayTeam, map.getOrDefault(awayTeam, 0) + 3);
                map.put(homeTeam, map.getOrDefault(homeTeam, 0));
            }
        }
        String winner = competitions.get(0).get(0);
        for (String key : map.keySet()) {
            if (map.get(key) > map.get(winner))
                winner = key;
        }
        return winner;
    }

    /* AlgoExpert First Duplicate Value */
    static int firstDuplicateValue(int[] array) {
        // Write your code here.
//        Using HashSet
//         Set<Integer> set = new HashSet<>();
//        for (int num : array) {
////            The Set.add() method returns true if the element was
////            successfully added else false. It returns false when
////            the set already contains the given element.
//            if(!set.add(num))
//                return num;
//        }
//        Using Cyclic sort
        int i = 0;
        while (i < array.length) {
            int correctIndex = array[i] - 1;
            if (array[i] == i + 1 && i != correctIndex) {
                i++;
                continue;
            }
//            else {
//                if (array[correctIndex] == array[i])
//                    return array[i];
//                else {
            int temp = array[i];
            array[i] = array[correctIndex];
            array[correctIndex] = temp;
//                }
//            }
//            i++;
        }
        System.out.println(Arrays.toString(array));
//        for (i = 0; i < array.length; i++) {
//            if (array[i] != i + 1)
//                return array[i];
//        }
        return -1;
    }

    //    Goldman Sachs: Hackerrank: Lottery Coupons
    static int lotteryCoupons(int n) {
        // Using HashMap. Time Complexity: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            int num = sumDigits(i);
            int j = map.put(num, map.getOrDefault(num, 0) + 1) == null ? 0 : map.get(num);
            max = Math.max(max, j);
        }
        if (n <= 9)
            return map.size();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                count++;
        }
        return count;
    }

    static int sumDigits(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }

    //    Goldman Sachs: Hackerrank: Palindrome Counter
    static int countPalindromes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            // Expanding the search in odd manner
            int left = i, right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                } else break;
            }

            // Expanding the search in even manner
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                } else break;
            }
        }
        return count;
    }

    /* AlgoExpert Sum of Linked Lists. Which is basically same as LeetCode: 2. Add Two Numbers.
     * Check LeetCode class for second and more optimized solution. */
    static ListNode sumOfLinkedLists(ListNode linkedListOne, ListNode linkedListTwo) {
        // Write your code here.
        int firstSum = 0, secondSum = 0, base = 1;
        while (linkedListOne != null) {
            firstSum += linkedListOne.val * base;
            base *= 10;
            linkedListOne = linkedListOne.next;
        }

        base = 1;
        while (linkedListTwo != null) {
            secondSum += linkedListTwo.val * base;
            base *= 10;
            linkedListTwo = linkedListTwo.next;
        }

        int sum = firstSum + secondSum;
        ListNode sumOfLinkedLists = new ListNode(sum % 10);
        ListNode tail = sumOfLinkedLists;
        sum /= 10;
        while (sum != 0) {
            tail.next = new ListNode(sum % 10);
            sum /= 10;
            tail = tail.next;
        }
        return sumOfLinkedLists;
    }

    static int lengthOfCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
        }
        return 0;
    }

    /* AlgoExpert: Next greater element, LeetCode: 503. Next Greater Element II */
    public static int[] nextGreaterElemenII(int[] array) {
        // Write your code here.
        // Brute Force: Overall Time Complexity O(n^2)
        // Overall Space complexity O(n);

        int[] ans = new int[array.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            ans[i] = array[i];
            max = Math.max(max, array[i]);
        }

        for (int i = 0; i < ans.length; i++) {
            int j = i + 1;
            // For each element, find the next greater element
            while (true) {
                // Since input array is a circular one,
                // set j to 0 if j >= array.length
                if (j >= array.length)
                    j = 0;
                // Since problem says set element to -1
                // if there's no such next greater element
                if (ans[i] == max) {
                    ans[i] = -1;
                    break;
                }
                // Set next greater element
                if (array[j] > ans[i]) {
                    ans[i] = array[j];
                    break;
                }
                j++;
            }
        }

        return ans;
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /* Brute Force: Time Complexity: O(n ^ 3)
         * Space Complexity: O(1) */
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length) {
                if (nums2[j] == nums1[i]) {
                    int k = j + 1;
                    while (k < nums2.length) {
                        if (nums2[k] > nums1[i]) {
                            nums1[i] = nums2[k];
                            break;
                        }
                        k++;
                        if (k >= nums2.length)
                            nums1[i] = -1;
                    }
                    break;
                }
                j++;
                if (j >= nums2.length)
                    nums1[i] = -1;
            }
        }
        return nums1;
    }

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> ans = new ArrayList<>();
//        int start = 0, end = p.length();
//        while (end <= s.length()) {
//            if (isAnagram(s.substring(start, end), p))
//                ans.add(start);
//            start++;
//            end++;
//        }
//        return ans;
//    }

    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) >= k) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
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
}