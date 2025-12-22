package Recursion.Easy;

public class CountDigits {

    // Brute force: convert number to string and count length
    public static int countDigitsBF(int n) {
        return Integer.toString(n).length();
    }

    // Optimized: recursion by dividing by 10
    public static int countDigitsOpt(int n) {
        if (n == 0) return 0;
        return 1 + countDigitsOpt(n / 10);
    }

    public static void main(String[] args) {
        int n = 123456;

        System.out.println("BF: " + countDigitsBF(n));
        System.out.println("Opt: " + countDigitsOpt(n));
    }
}
