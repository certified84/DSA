public class GCD_LCM {
    public static void main(String[] args) {
        int a = 18, b = 9;
        System.out.println(lcm(a, b));
    }

//    Euclidean algorithm for finding GCD or HCF
    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        int d = gcd(a, b), f = a / d, g = b / d;
        return d * f * g;

//        Better solution is to use the formula
//        return (a * b) / gcd(a, b);
    }
}
