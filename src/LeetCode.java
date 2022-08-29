import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class LeetCode {

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        String name = new String("Sammie");
        String name2 = new String("Sammie");
        int target = 3;
        System.out.println(searchInRotated(nums, target));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //    LeetCode: 1672. Richest Customer Wealth
    static int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int money : account) {
                sum += money;
            }
            if (sum > wealth) wealth = sum;
        }
        return wealth;
    }

    //    LeetCode 1431. Kids With the Greatest Number of Candies
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < n; i++) {
            int richest = candies[i] + extraCandies;
            boolean isGreater = false;
            for (int candy : candies) {
                if (richest >= candy) isGreater = true;
                else {
                    isGreater = false;
                    break;
                }
            }
            result.add(i, isGreater);
        }
        return result;
    }

    static List<Boolean> otherKidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        for (int candy : candies) {
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }

    //    LeetCode 744. Find Smallest Letter Greater Than Target
    static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

//        Since the letters wrap around
        if (target >= letters[letters.length - 1]) return letters[0];

//        Binary search
        while (start <= end) {

            int mid = start + ((end - start) / 2);

            if (target < letters[mid]) end = mid - 1;
            else start = mid + 1;

        }
        return letters[start % letters.length];
    }

    //    LeetCode 34. Find First and Last Position of Element in Sorted Array
    static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int startIndex = -1;
        int endIndex = -1;

//        Binary search to find the first index
        while (start <= end) {

            int mid = end - ((end - start) / 2);

            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                startIndex = mid;
                end = mid - 1;
            }
        }

//        Binary search to find the Last index
        start = 0;
        end = nums.length - 1;
        while (start <= end) {

            int mid = end - ((end - start) / 2);

            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                endIndex = mid;
                start = mid + 1;
            }
        }

        return new int[]{startIndex, endIndex};
    }

    // Using two separate methods for each index
    static int[] otherSearchRange(int[] nums, int target) {
        int[] ans = {0, 0};

        ans[0] = findFirstIndex(nums, target);
        ans[1] = findLastIndex(nums, target);

        return ans;
    }

    //    Method to find firstIndex
    private static int findFirstIndex(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int firstIndex = -1;

        while (start <= end) {

            int mid = end - ((end - start) / 2);

            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                firstIndex = mid;
                end = mid - 1;
            }

        }

        return firstIndex;
    }

    // Method to find last index
    private static int findLastIndex(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int lastIndex = -1;

        while (start <= end) {

            int mid = end - ((end - start) / 2);

            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                lastIndex = mid;
                start = mid + 1;
            }

        }

        return lastIndex;
    }

    //    LeetCode: 852. Peak Index in a Mountain Array & 162. Find Peak Element
    static int peakIndex(int[] arr) {

        int start = 0, end = arr.length - 1, ans = -1;

        while (start < end) {

            int mid = start + ((end - start)) / 2;

//             Since arr[mid] is greater than arr[mid+1], all other elements
//             on the right should be ignored as this indicates the decreasing
//             part of the mountain array and this could be the potential
//             answer. end here shouldn't be equal to mid - 1 since mid is a
//             potential answer, and it has to be included in future checks.

            if (arr[mid] > arr[mid + 1]) end = mid;

//             Since start will never be equal to end and arr[mid] is less than
//             arr[mid+1], every element on the left including arr[mid] should
//             be ignored (arr[mid] is not a potential answer) as this is the
//             increasing part of the mountain array.

            else start = mid + 1;
        }

//         In the end, start will definitely equal end because the two checks in
//         the loop are trying to find the largest elements and once they both point
//         to the same element, this is the largest element.
        return start;
    }

    //    LeetCode: 278. First Bad Version
    static int firstBadVersion(int n) {

        int start = 1, end = n, ans = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            boolean isBad = isBadVersion(mid);

            if (isBad) {
//                 Potential answer found
                ans = mid;
//                 Search on the left
                end = mid - 1;
            } else {
//                 Search on the right
                start = mid + 1;
            }
        }
        return ans;
    }

    static boolean isBadVersion(int number) {
        return number == 4;
    }

    //    LeetCode: 167. Two Sum II - Input Array Is Sorted
    static int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;

//        While loop because we don't know the number of iterations
        while (start < end) {
            int number = numbers[start] + numbers[end];
//            Since target < numbers[start] + numbers[end], the required elements are on the left
            if (number > target) end--;
//            Since target > numbers[start] + numbers[end], the required elements are on the right
            else if (number < target) start++;
//            if none of the conditions above pass, the indexes have been found since start is always < end
            else break;
        }

//        The question says return the start and end indexes as start + 1 and end + 1
        return new int[]{++start, ++end};
    }

    //    LeetCode: 441. Arranging Coins
    static int arrangeCoins(int n) {
        int count = 0, i = 1;
        while (n >= 0) {
            n -= i++;
            if (n < 0) break;
            count++;
        }
        return count;
    }

    //    LeetCode: 1539. Kth Missing Number
    static int findKthPositive(int[] arr, int k) {

        List<Integer> op = new ArrayList<Integer>(arr.length);
        int[] newArr = new int[k];
        int complete = 0;

        for (int j : arr) {
            op.add(j);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (complete >= k) break;
            if (!op.contains(i)) {
                newArr[complete] = i;
                complete++;
            }
        }

        return newArr[k - 1];
    }

    //    LeetCode: 35. Search Insert Position
    static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid; // the middle element could be a potential answer, check on the left
            else start = mid + 1; // check on the right
        }

        // 1 element left at the end and start == end
        // post-processing
        // The statement says; if the number at start < target return start + 1 else return start
        return nums[start] < target ? start + 1 : start;
    }

    //    LeetCode: 704. Binary Search
    static int search(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            if (arr[start] == target) return start;

            if (arr[end] == target) return end;

            int mid = start + ((end - start) / 2);

            if (target < arr[mid]) end = mid - 1;
            else if (target > arr[mid]) start = mid + 1;
            else return mid;
        }
        return -1;
    }

    //    LeetCode: 1351. Count Negative Numbers in a Sorted Matrix
    static int countNegatives(int[][] grid) {
//        Brute force: O(n^2)
        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt < 0) count++;
            }
        }

//        int row = 0, col = grid.length - 1, count = 0;
//        while (row < grid.length && col >= 0) {
//            if (grid[row][col] < 0)
//                count++;
//            row++;
//            col--;
//        }

        return count;
    }

    //    LeetCode: 349. Intersection of Two Arrays
    static int[] intersection(int[] nums1, int[] nums2) {

        /* Create 2 new hash sets: one that contains all the elements in num2, and
        another that will contain the solution (intersection of num1 and num2)*/
        HashSet<Integer> list = new HashSet<>();
        HashSet<Integer> sol = new HashSet<>();

        /* Add all the elements from num2 to list; Actually, duplicate items will not be
        added to a hash set. Hash sets only contains unique items */
        for (int j : nums2) {
            list.add(j);
        }

//         Loop through each element in num1 and check that the element exists in num2
        for (int k : nums1) {
            if (list.contains(k)) sol.add(k);
        }

//         Return the solution as an array.
        return sol.stream().mapToInt(Integer::intValue).toArray();
    }

    //    LeetCode: 888. Fair Candy Swap
    static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
//         Sum all the elements in aliceSizes and bobSizes, subtract sum of bobSizes
//         from aliceSizes and divide by 2 to get the difference (Really don't why I'm
//         dividing by 2).
        int aliceSizesSum = 0, bobSizesSum = 0;
        for (int a : aliceSizes)
            aliceSizesSum += a;
        for (int b : bobSizes)
            bobSizesSum += b;
        int diff = (IntStream.of(aliceSizes).sum() - IntStream.of(bobSizes).sum()) / 2;

//         Create new hash set and add all elements from aliceSizes. Remember only unique
//         elements will be added.
        HashSet<Integer> sol = new HashSet<>();
        for (int a : aliceSizes) sol.add(a);

//         Loop through each element in bobSizes and check if sol contains that element + diff
//         If it does, return a new array containing b and b + diff.
        for (int b : bobSizes) if (sol.contains(b + diff)) return new int[]{b + diff, b};

//         Since it is guaranteed that at least one solution exists, this statement is never reached
        return new int[0];
    }

    //    LeetCode: 1346. Check If N and Its Double Exist
    static boolean checkIfExist(int[] arr) {
        boolean exist = false;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i] == 2 * arr[j]) return true;
            }
        return exist;
    }

    //    LeetCode: 2154. Keep Multiplying Found Values by Two
    static int findFinalValue(int[] nums, int original) {
//         Define two variables: ans; which is the value to
//         be returned and i; which handles the loop
        int ans = original;
        int i = 0;

//         Loop through the entire array: 0 <= i < nums.length
        while (i < nums.length) {
//             As per requirements, when the original number is found,
//             multiply it by 2 and start the loop from 0.
            if (nums[i] == ans) {
                ans *= 2;
                i = 0;
                continue;
            }
            i++;
        }

//         At the end, ans will hold the correct value. Just return it.
        return ans;
    }

    //    LeetCode: 33. Search in Rotated Sorted Array
    static int searchInRotatedSortedArray(int[] nums, int target) {

        int pivot = findPivot(nums);

//        When pivot isn't found i.e nums is not a rotated array,
//        Perform the normal BS to find the target.
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

//        When the nums[pivot] == target, return pivot
        if (nums[pivot] == target) return pivot;

        int start = 0, end = nums.length - 1, ans = -1;

//        When target >= nums[start] target lies on the left of pivot. Hence,
//        perform a BS from 0 to pivot - 1. Condition is target >= nums[start]
//        because start could be the potential position of the target.
        if (target >= nums[start]) ans = binarySearch(nums, target, start, pivot - 1);
//        When the condition above doesn't pass, target will lie on the right
//        of pivot. Perform a BS from pivot + 1 to nums.length - 1
        else ans = binarySearch(nums, target, pivot + 1, end);

//        In the end, when target isn't found, ans == -1
        return ans;
    }

    //    BS to find pivot or peak element in a rotated array.
    static int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            mid should always be less than end to avoid index out of bound exception.
//            Index out of bound exception will occur when nums[mid] is the last
//            element in the array i.e nums[mid] == nums.length - 1;
//            Since nums[mid] > nums[mid+1], and nums is a rotated array, this shows
//            that nums[mid] is the pivot because in a rotated array, only one element
//            can be greater than the next and this is the peak element
            if (mid < end && nums[mid] > nums[mid + 1]) return mid;
//            mid should always be greater than start to avoid index out of bound exception.
//            Index out of bound exception will occur when nums[mid] is the first
//            element in the array i.e nums[mid] == nums[0];
//            Since nums[mid] < nums[mid-1], and nums is a rotated array, this shows
//            that nums[mid - 1] is the pivot because in a rotated array, only one element
//            can be greater than the next and this is the peak element
            else if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;
//            When nums[start] > nums[mid], this shows that the peak element lies on the
//            left of mid. Hence, end = mid - 1;
            else if (nums[start] > nums[mid]) end = mid - 1;
//            If none of the conditions above passes, this shows that the peak element
//            lies on the right of mid. Hence, start = mid + 1;
            else start = mid + 1;
        }
//        In the end, return -1 because nums is not a rotated array.
        return -1;
    }

    //    Normal binary search with search range.
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {

            if (arr[start] == target) return start;

            if (arr[end] == target) return end;

            int mid = start + ((end - start) / 2);

            if (target < arr[mid]) end = mid - 1;
            else if (target > arr[mid]) start = mid + 1;
            else return mid;
        }
        return -1;
    }

    //    LeetCode: 540. Single Element in a Sorted Array
    static int singleNonDuplicate(int[] nums) {
        /* The array is sorted; Use Binary Search
        * Every element appears exactly twice except one that appear once
        * Minimum length of array will be 3
        * The pattern: Observe that for every duplicate, the first element
          has even index while the second has odd index.
        * The above will be true until single element is introduced.
         */
        int start = 0, end = nums.length - 1, ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
//            If middle element index is even, its duplicate should be on the right
            if (mid % 2 == 0) {
//                If the duplicate of the middle element is on the right,
//                the pattern still holds. Hence, single element is on the right.
                if (nums[mid] == nums[mid + 1]) start = mid + 1;
//                Else, the pattern doesn't hold and single element is on the left.
                else end = mid;
            }
//            Else middle element index is odd, its duplicate should be on the left
            else {
//                If the duplicate of the middle element is on the left,
//                the pattern still holds. Hence, single element is on the right.
                if (nums[mid] == nums[mid - 1]) start = mid + 1;
//                Else, the pattern doesn't hold and single element is on the left.
                else end = mid;
            }
        }
//        At the end, start and end will point to the same element and this is the
//        single element in the array.
        return nums[start];
    }

    //    LeetCode: 153. Find Minimum in Rotated Sorted Array
    static int findMin(int[] nums) {

        /* The array is sorted; Use Binary Search
         * Note that in a rotated sorted array, elements after the
         * pivot or peak element are ascending while elements before
         * it are descending. And this shows that the minimum or
         * smallest element in the array is either the first element
         * in the array or the element after the pivot/peak element.
         */

//         position of peak element.
        int pivot = findPivot(nums);

//        If pivot == -1, this shows that nums is not rotated and as a
//        result, nums[0] is the minimum element.
        if (pivot == -1) return nums[0];

//        In a rotated array, peak element cannot be the last element.
//        Since the above is true, return the smallest element between
//        nums[0] and nums[pivot + 1]
//        if (nums[0] > nums[pivot + 1])
//            return nums[pivot + 1];
//        else return nums[0];
        return Math.min(nums[0], nums[pivot + 1]);
    }

    /* LeetCode: 268. Missing Number */
    static int findMissing(int[] arr) {
        /*
         * Since arr is between the range (0,arr.length), and only one number
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
            if (i < arr.length) actualSum += arr[i];
        }
        System.out.println(expectedSum - actualSum);
        return expectedSum - actualSum;
    }

    /* Another method of finding missing number using Cyclic sort algorithm.
     * Here, the array is first sorted before the missing number is found. */
    static int cyclicSort(int[] arr) {
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
//            Increment i if arr[i] is at the correct position i.e arr[i] == i or arr[i]
//            is the last index (i.e. Ignore the element meant to be at arr[arr.length])
            if (arr[i] == arr.length || arr[i] == i) i++;
//            Else swap arr[i] with arr[arr[i]]
            else swap(arr, i, arr[i]);
        }
        return missingNumber(arr);
    }

    //    This method finds the missing number in a sorted array.
    static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i) return i;
            i++;
        }
        return arr.length;
    }

    /* LeetCode: 448. Find All Numbers Disappeared in an Array */
    static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
//            Correct position of current element
            int j = arr[i] - 1;
//            If current element is not equal to element at correct index,
//            Swap the elements. This check ignores duplicates.
            if (arr[i] != arr[j]) swap(arr, i, j);
//            If the check above doesn't pass, that means current element
//            is already at correct position. Increment i
            else i++;
        }
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) disappearedNumbers.add(i + 1);
        }
        return disappearedNumbers;
    }

    /* LeetCode: 287. Find the Duplicate Number */
    static int findDuplicate(int[] arr) {
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
//             Correct position of current element.
//             Since range is (1,n), we don't have to bother about
//             Index out of bound exception.
            int j = arr[i] - 1;
//            Since range is (1,n) arr[i] should equal i + 1
//            i.e. arr[0] == 0+1 = 1
            if (arr[i] != i + 1) {
//                Since there is only one duplicate, if arr[i] != arr[j]
//                where j is the correct index of the current element,
//                swap the current element with the one at the correct index
                if (arr[i] != arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
//                If the check above doesn't pass, that means current
//                element is equal to element in correct index.
//                This is the duplicate element.
                else return arr[i];
            }
//            If the check above doesn't pass, that means current element
//            is already at correct position. Increment i
            else i++;
        }
        return 0;
    }

    /* LeetCode: 442. Find All Duplicates in an Array */
    static List<Integer> findDuplicates(int[] arr) {
//     The solution to this problem is exactly the same solution for
//     LeetCode: 448. Find All Numbers Disappeared in an Array
//     With the only difference being that instead of adding the
//     disappeared elements to the list, we add the duplicates which
//     are all the elements not in the correct position after the array
//     has been sorted.
        List<Integer> duplicates = new ArrayList<>();
        int i = 0;
//        Loop through the entire array
        while (i < arr.length) {
//            Correct position of current element
            int j = arr[i] - 1;
//            If current element is not equal to element at correct index,
//            Swap the elements. This check ignores duplicates.
            if (arr[i] != arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
//            If the check above doesn't pass, that means current element
//            is already at correct position. Increment i
            else i++;
        }
//         Loop through the array, all the elements that are not in the
//         correct position are the duplicates.
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) duplicates.add(arr[i]);
        }
        return duplicates;
    }

    static String findPangram(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        if (s.toLowerCase().matches("[a-zA-Z]")) return "pangram";
        else return "not pangram";
    }

    /* LeetCode: 645. Set Mismatch */
    static int[] findErrorNums(int[] nums) {
        int[] result = new int[]{0, 0};
        int i = 0;
//        Loop through the entire array
        while (i < nums.length) {
//             Correct position of current element.
//             Since range is (1,n), we don't have to bother about
//             Index out of bound exception.
            int j = nums[i] - 1;
//            Since range is (1,n) arr[i] should equal i + 1
//            i.e. arr[0] == 0+1 = 1
            if (nums[i] != i + 1) {
//                Since there is only one duplicate, if arr[i] != arr[j]
//                where j is the correct index of the current element,
//                swap the current element with the one at the correct index
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
//                If the check above doesn't pass, that means current
//                element is equal to element in correct index.
//                This is the duplicate element.
                else {
                    result[0] = nums[i];
                    i++;
                }
            }
//            If the check above doesn't pass, that means current element
//            is already at correct position. Increment i
            else i++;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result[1] = j + 1;
                return result;
            }
        }
        return result;
    }

    /* LeerCode: 41. First Missing Positive */
    static int firstMissingPositive(int[] nums) {
        /*
         * This solution is pretty much the same as the missing number
         * solution. Only difference here is that this problem contains
         * negative numbers.
         * Solution: Use cyclic sort to sort the elements in the array.
         * While sorting, ignore negative numbers and numbers >= the
         * length of the array. After sorting, the element not in the
         * correct index is the first missing positive number. Where
         * the correct index of the element at i is i+1 because we are
         * dealing with elements in the range (1,n). E.g arr[0] == 1.
         * At the end, return nums.length + 1 because 0 isn't a positive
         * number and nums.length might equal 0.
         */
        int i = 0;
        while (i < nums.length) {
//            Correct index of the current element
            int j = nums[i] - 1;
//            Check that the current element is greater than zero, less than
//            nums.length and is not at the correct index. If this is not the
//            case, swap the element with the element at the correct index.
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
//            When the check above doesn't pass, this means that the current
//            element might be negative (should be ignored), zero (should be
//            ignored since zero isn't positive) or is already at the correct
//            index hence, increment i.
            else i++;
        }
        System.out.println(Arrays.toString(nums));
//        Loop through the array and find the first missing positive number.
        for (i = 0; i < nums.length; i++) {
//            If nums[i] != i + 1, this is the first missing positive
//            number. e.g. nums[0] == 1
            if (nums[i] != i + 1) return i + 1;
        }
//        At the end, return nums.length + 1
        return nums.length + 1;
    }

    /* LeetCode: 169. Majority Element */
    static int majorityElement(int[] nums) {
        /*
         * So I found that some dude already invented an algorithm
         * for this problem, and it is called the Linear Time
         * Majority Vote Algorithm. It can be found here:
         * https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
         * So what this algorithm basically does is each element
         * votes for itself against other elements and in the end,
         * the element with the most votes wins.
         */

//        Initially, the majority element and its votes is unknown
//        and the counter is 0
        int major = 0;
        int count = 0;
//        We loop through the elements
        for (int i = 0; i < nums.length; i++) {
//            if count == 0, we set the major element to the
//            current element and increment count
            if (count == 0) {
                major = nums[i];
                count++;
            }
//            If the counter is not 0, we increment or decrement
//            the counter according to whether e is the current
//            candidate. i.e, if major element == current element,
//            we increment count
            else if (major == nums[i]) {
                count++;
            }
//            Else, we decrement count.
            else count--;
        }
        return major;
    }

    /* LeetCode: 414. Third Maximum Number */
    static int thirdMax(int[] nums) {
        /*
         * The solution below only works with arrays that doesn't have
         * duplicates. The idea is to just basically sort the array
         * using Cyclic sort (O(n) time), then loop through the sorted
         * array from nums.length - 1 to 0 and increment a counter until
         * we reach 3. The element at the time the counter is three is
         * the third maximum element. When the third maximum element
         * doesn't exist, return the largest element in the array.
         */
        int count = 0, i = 0, thirdMax = Integer.MAX_VALUE, max = 0;
        boolean hasDuplicate = false;
        while (i < nums.length) {
            int j = nums[i] - 1;

            if (nums[i] <= nums.length && nums[i] != 0 && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
                if (i == j)
                    hasDuplicate = true;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max)
                max = nums[i];
            if (hasDuplicate) {
                hasDuplicate = false;
                continue;
            }
            if (nums[i] < thirdMax) {
                thirdMax = nums[i];
                count++;
                if (count >= 3) {
                    return nums[i];
                }
            }
        }
        return max;
    }

    /* LeetCode: 455. Assign Cookies */
//    static int findContentChildren(int[] g, int[] s) {
//        int i = 0, j = 0;
//        while (i < g.length) {
//            int correct =
//            if (g[i] )
//        }
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int i = 0;
//        for (int j = 0; i < g.length && j < s.length; j++) {
//            if (g[i] <= s[j]) i++;
//        }
//        return i;
//    }

    /*LeetCode: 628. Maximum Product of Three Numbers */
    static int maximumProduct(int[] arr) {
//         Using insertion sort
//        External loop handles the sorting
        for (int i = arr.length - 1; i >= 0; i--) {
//        This variable keeps track of the current largest element
            int largest = 0;
//            Internal loop handles finding the largest element
            for (int j = 0; j <= i; j++) {
                if (Math.abs(arr[j]) > Math.abs(arr[largest])) {
                    largest = j;
                }
            }
//            If i == largest, that means arr[i] is already sorted
            if (i == largest)
                continue;
//            Swap the largest element to its correct position.
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }

        System.out.println(Arrays.toString(arr));

        int maxProduct = 1;
        int count = 0;
        int k = arr.length - 1;
        while (count < 3 && k >= 0) {
            maxProduct *= arr[k];
            k--;
            count++;
        }
        return maxProduct;
    }

    /* LeetCode: 1108. Defanging an IP Address */
    static String defangIPaddr(String address) {
//        Use a sting builder for better performance
        StringBuilder builder = new StringBuilder();
//        Loop through the address (O(n) time)
        for (int i = 0; i < address.length(); i++) {
//            If the current character is a dot, append [.] to the builder
            if (address.charAt(i) == '.')
                builder.append("[.]");
//            Else, append the current character to the builder
            else builder.append(address.charAt(i));
        }
//        Return the builder's string
        return builder.toString();
    }

    /* LeetCode: 1528. Shuffle String */
    static String restoreString(String s, int[] indices) {
//         Convert the string s to a CharArray to easily carryout cyclic sort.
        char[] arr = s.toCharArray();
//         Using cyclic sort since elements are in range (0,n)
        int i = 0;
        while (i < indices.length) {
            int j = indices[i];
//             If (current element != i) swap.
//             e.g if indices[0] != 0
            if (indices[i] != i) {
//                 Swap the indices. The indices hold the correct position of the characters.
                int temp = indices[i];
                indices[i] = indices[j];
                indices[j] = temp;
//                     Swap the characters
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
            } else
                i++;
        }
//         In the end, return the string value of the CharArray.
        return String.valueOf(arr);
    }

    /* LeetCode: 81. Search in Rotated Sorted Array II */
    static boolean searchInRotated(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length;
//        int pivot = findPivot(nums);
//        while ()
        return false;
    }

    /* LeetCode: 4. Median of Two Sorted Arrays */
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         First create a new array to store the merged arrays
        int[] mergedNums = mergeSortedArray(nums1, nums2);
//         Two conditions needs to be checked to determine the median to be returned
//         Check if the length of the mergedNums is even or odd.
//         If it is even, return (mergedNums[mid] + mergedNums[mid + 1]) / 2.0
//         else, return mergedNums[mid]
        int mid = (mergedNums.length - 1) / 2;
        if (mergedNums.length % 2 == 0)
            return (mergedNums[mid] + mergedNums[mid + 1]) / 2.0;
        else
            return mergedNums[mid];
    }

    static int[] mergeSortedArray(int[] nums1, int[] nums2) {
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
        return mergedArray;
    }

    /* LeetCode: 74. Search a 2D Matrix */
    static boolean searchMatrix(int[][] matrix, int target) {

//        Brute force solution: Using Linear Search with O(n^2) time complexity
        /*for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target)
                    return true;
            }
        }*/

//        Using two pointer method since matrix is row column sorted. O(n) time complexity
        /*int row = 0, col = matrix[row].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }*/

//        Using binary search method since matrix is row column sorted. O(log(n)) time complexity
        int rStart = 0, rEnd = matrix.length - 1;
        int current = rStart + (rEnd - rStart) / 2;
        int colStart = 0, colEnd = matrix[current].length - 1;
        while (rStart < rEnd && colStart < colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[current][mid] == target)
                return true;
            else if (matrix[current][mid] > target) {
                colEnd = mid - 1;
            }
            else
                colStart = mid + 1;
        }

        return false;
    }
}