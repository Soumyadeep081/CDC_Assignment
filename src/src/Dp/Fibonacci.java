package Dp;

import java.util.*;

public class Fibonacci {
    static int solve(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int prev = 0;
        int prev2 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev + prev2;
            prev = prev2;
            prev2 = curr;
        }
        return prev2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
