package Advanced_Dp;

import java.util.*;

public class MinCostClimbingStairs {

    // Top-down approach (Recursion with Memoization)
    private static int minCostClimbingStairsTopDown(int[] cost, int n, int[] memo) {
        if (n == 0 || n == 1) {
            return cost[n];
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = cost[n] + Math.min(
                minCostClimbingStairsTopDown(cost, n - 1, memo),
                minCostClimbingStairsTopDown(cost, n - 2, memo)
        );
        return memo[n];
    }

    // Bottom-up approach (Iterative DP)
    public static int minCostClimbingStairsBottomUp(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int n = cost.length;

        // Top-down
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int minCostTopDown = Math.min(
                minCostClimbingStairsTopDown(cost, n - 1, memo),
                minCostClimbingStairsTopDown(cost, n - 2, memo)
        );
        System.out.println("Minimum cost (Top-down): " + minCostTopDown);

        // Bottom-up
        int minCostBottomUp = minCostClimbingStairsBottomUp(cost);
        System.out.println("Minimum cost (Bottom-up): " + minCostBottomUp);
    }
}
