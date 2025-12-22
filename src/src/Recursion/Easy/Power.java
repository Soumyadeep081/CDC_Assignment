package Recursion.Easy;

public class Power {

    // Brute force: multiply x n times
    static long powBF(int x, int n) {
        long res = 1;
        for (int i = 0; i < n; i++) res *= x;
        return res;
    }

    // Optimized: exponentiation by squaring
    static long powOpt(int x, int n) {
        if (n == 0) return 1;
        long half = powOpt(x, n / 2);
        if (n % 2 == 0) return half * half;
        return x * half * half;
    }

    public static void main(String[] args) {
        int x = 2, n = 10;
        System.out.println("BF: " + powBF(x, n));
        System.out.println("Opt: " + powOpt(x, n));
    }
}

