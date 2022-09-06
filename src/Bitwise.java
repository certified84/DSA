public class Bitwise {
    public static void main(String[] args) {
        int n = 3;
        int i = 5;
        System.out.println(magicNumber(n));
    }

    static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    static int findBit(int n, int i) {
        return n & (1 << i - 1);
    }

    static int setBit(int n, int i) {
        return n | (1 << i - 1);
    }

    static int resetBit(int n, int i) {
//        return n & !(1 << i - 1);
        return n & (1 << i - 1);
    }

    static int magicNumber(int n) {
        int ans = 0, base = 5;
        while (n > 0) {
//            last bit
            int last = n & 1;
//            Get rid of one bit every iteration
            n = n >> 1;
            ans += last * base;
            base *= 5;
        }
        return ans;
    }

    static int singleNumber(int[] nums) {
//        Optimized using bit manipulation (XOR) with
//        O(n) time complexity and O(1) space complexity
        int single = 0;
//        What I think the XOR does is that it kinda sums the
//        elements. When it encounters an element for the first
//        time, it either gets increased or decreased by it. The
//        next time it encounters the same element, it does the opposite
//        of the previous time. E.g. 4 ^ 1 gives 5 and 5 ^ 1 gives 4.
//        Hence, it simulates ignoring duplicates.
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
