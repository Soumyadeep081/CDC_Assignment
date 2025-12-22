package Advanced_Dp;

import java.util.*;

public class PerfectSquares {

    // Bottom-up Dynamic Programming Approach
    public static int numSquaresBottomUp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    // Top-down Dynamic Programming Approach (Recursive with Memoization)
    private static int numSquaresTopDownHelper(int n, int[] memo) {
        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];

        int minCount = Integer.MAX_VALUE;
        for (int j = 1; j * j <= n; j++) {
            minCount = Math.min(
                    minCount,
                    numSquaresTopDownHelper(n - j * j, memo) + 1
            );
        }
        memo[n] = minCount;
        return minCount;
    }

    public static int numSquaresTopDown(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return numSquaresTopDownHelper(n, memo);
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println("Bottom-up approach: " + numSquaresBottomUp(n));
        System.out.println("Top-down approach: " + numSquaresTopDown(n));
    }
}
