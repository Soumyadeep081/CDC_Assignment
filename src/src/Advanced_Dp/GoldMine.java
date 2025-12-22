package Advanced_Dp;

import java.util.*;

public class GoldMine {

    // Bottom-up Dynamic Programming Approach
    public static int maxGoldBottomUp(int[][] gold) {
        int m = gold.length;
        if (m == 0) return 0;
        int n = gold[0].length;

        int[][] dp = new int[m][n];

        // Fill the last column
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = gold[i][n - 1];
        }

        // Fill from right to left
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                int right = dp[i][j + 1];
                int rightUp = (i > 0) ? dp[i - 1][j + 1] : 0;
                int rightDown = (i < m - 1) ? dp[i + 1][j + 1] : 0;

                dp[i][j] = gold[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        // Find max in first column
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        return maxGold;
    }

    // Top-down Dynamic Programming Approach (Recursive with Memoization)
    private static int maxGoldTopDownHelper(int i, int j, int[][] gold, int[][] memo) {
        int m = gold.length;
        int n = gold[0].length;

        if (i < 0 || i >= m || j >= n) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int right = maxGoldTopDownHelper(i, j + 1, gold, memo);
        int rightUp = maxGoldTopDownHelper(i - 1, j + 1, gold, memo);
        int rightDown = maxGoldTopDownHelper(i + 1, j + 1, gold, memo);

        memo[i][j] = gold[i][j] + Math.max(right, Math.max(rightUp, rightDown));
        return memo[i][j];
    }

    public static int maxGoldTopDown(int[][] gold) {
        int m = gold.length;
        if (m == 0) return 0;
        int n = gold[0].length;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            maxGold = Math.max(maxGold, maxGoldTopDownHelper(i, 0, gold, memo));
        }
        return maxGold;
    }

    public static void main(String[] args) {
        int[][] gold = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        System.out.println("Bottom-up approach: " + maxGoldBottomUp(gold));
        System.out.println("Top-down approach: " + maxGoldTopDown(gold));
    }
}
