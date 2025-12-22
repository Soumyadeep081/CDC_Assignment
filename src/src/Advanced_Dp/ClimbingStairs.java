package Advanced_Dp;

import java.util.*;

public class ClimbingStairs {

    // Top-down approach (Recursion with Memoization)
    private static int climbStairsTopDown(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = climbStairsTopDown(n - 1, memo)
                + climbStairsTopDown(n - 2, memo);
        return memo[n];
    }

    // Bottom-up approach (Iterative DP)
    public static int climbStairsBottomUp(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of stairs: ");
        int n = sc.nextInt();

        // Top-down
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int waysTopDown = climbStairsTopDown(n, memo);
        System.out.println("Number of ways (Top-down): " + waysTopDown);

        // Bottom-up
        int waysBottomUp = climbStairsBottomUp(n);
        System.out.println("Number of ways (Bottom-up): " + waysBottomUp);
    }
}
