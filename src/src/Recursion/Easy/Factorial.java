package Recursion.Easy;

public class Factorial {

    // Brute force: iterative factorial
    static long factBF(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    // Optimized: recursive factorial
    static long factOpt(int n) {
        if (n <= 1) return 1;
        return n * factOpt(n - 1);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("BF: " + factBF(n));
        System.out.println("Opt: " + factOpt(n));
    }
}

