import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Bitwise {
    public static void main(String[] args) {
        int n = 15;
        int i = 5;
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
            System.out.println(n);
            ans += last * base;
            base *= 5;
        }
        return ans;
    }

    static boolean powOfTwo(int n) {
        /* The binary representation of a number with the power of two takes the form
         * 1xxx where xxx is any number of zeros e.g. 2 = 10, 4 = 100, 8 = 1000, 16 = 10000
         * and so on. Hence, the number before it will take the form yyy where yyy is any
         * number of one's e.g. 1 = 1, 3 = 11, 7 = 111, 15 = 1111. Hence, a number n is a
         * power of 2 if n & (n-1) == 0. */
        if (n == 0)
            return false;
        return (n & (n - 1)) == 0;
    }

    static int numberOfBits(int n, int base) {

//        Only works for binary representation
//        int count = 0;
//        while (n > 0) {
//            n = n >> 1;
//            count++;
//        }
//        return count;

        return (int) (Math.log(n) / Math.log(base)) + 1;
    }

    static int numberOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            System.out.println(Integer.toBinaryString(n));
            n = n & (n - 1);
//            if ((n & 1) == 1)
            count++;
//            n = n >> 1;
        }
        return count;
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

    static int pow(int x, int y) {
        int ans = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                ans *= x;
            x *= x;
            y = y >> 1;
        }
        return ans;
    }

    static int xorFromZeroToN(int n) {
//        int xor = 0;
//        while (n > 0) {
//            xor ^= n;
//            n--;
//        }
//        return xor;

//        Based on the repeating pattern of XOR from 0 to n
        if (n % 4 == 0)
            return n;

        if (n % 4 == 1)
            return 1;

        if (n % 4 == 2)
            return n + 1;

        return 0;
    }

    static int xorFromXToN(int start, int end) {

//        int xor = xorFromZeroToN(end);
//        while (start > 0) {
//            xor ^= start;
//            start--;
//        }
//        return xor;

        int xorN = xorFromZeroToN(end);
        int xorX = xorFromZeroToN(start - 1);
        return xorX ^ xorN;
    }

    static void trackTest() {

//        String[] split = lines[1].split(" ");

//        Question 1:
//        String[] lines = getStdin();
//        StringBuilder builder = new StringBuilder(lines[0]);
//        int n = Integer.parseInt(split[0]);
//        char c = split[1].charAt(0);
//        builder.replace(n - 1, n, String.valueOf(c));
//        System.out.println(builder);

//        Question 2:
//        int[] gardens = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            gardens[i] = Integer.parseInt(split[i]);
//        }
//        Arrays.sort(gardens);
//
//        if (gardens.length == 2) {
//            System.out.println(gardens[1]);
//            System.out.println(gardens[0]);
//        } else {
//            for (int i = 0; i < gardens.length - 1; i++) {
//                if (gardens[i] == gardens[gardens.length - 1]) {
//                    System.out.println(gardens[gardens.length - 2]);
//                    continue;
//                }
//                System.out.println(gardens[gardens.length - 1]);
//            }
//            System.out.println(gardens[gardens.length - 2]);
//        }

//        Question 3:
//        String q = args[0];
//        try {
//            String endpoint = "http://challenge-server.code-check.io/api/hash?q=" + q;
//            URL url = new URL(endpoint);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//
//            int code = connection.getResponseCode();
//
//            if (code == 200) {
//
//                StringBuilder builder = new StringBuilder();
//                Scanner scanner = new Scanner(url.openStream());
//                while (scanner.hasNext()) {
//                    builder.append(scanner.nextLine());
//                }
//                scanner.close();
//
//                JSONParser parser = new JSONParser();
//                JSONObject data = (JSONObject) parser.parse(builder.toString());
//                System.out.println(data.get("hash"));
//            }
//
//            connection.disconnect();
//        } catch(Exception e) {
//            System.out.println(e.getLocalizedMessage());
//        }
    }
}
