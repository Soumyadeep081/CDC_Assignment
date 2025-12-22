package Advanced_Dp;

import java.util.*;

public class MaxPathSumGrid {

    // Bottom-up Dynamic Programming Approach
    public static int maxPathSumBottomUp(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // First row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // First column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    // Top-down Dynamic Programming Approach (Recursive with Memoization)
    private static int maxPathSumTopDownHelper(int i, int j, int[][] grid, int[][] memo) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE;
        if (memo[i][j] != -1) return memo[i][j];
        if (i == 0 && j == 0) {
            memo[i][j] = grid[0][0];
            return memo[i][j];
        }

        int up = (i > 0) ? maxPathSumTopDownHelper(i - 1, j, grid, memo) : Integer.MIN_VALUE;
        int left = (j > 0) ? maxPathSumTopDownHelper(i, j - 1, grid, memo) : Integer.MIN_VALUE;

        memo[i][j] = grid[i][j] + Math.max(up, left);
        return memo[i][j];
    }

    public static int maxPathSumTopDown(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return maxPathSumTopDownHelper(m - 1, n - 1, grid, memo);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println("Bottom-up approach: " + maxPathSumBottomUp(grid));
        System.out.println("Top-down approach: " + maxPathSumTopDown(grid));
    }
}
