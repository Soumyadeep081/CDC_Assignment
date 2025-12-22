package Advanced_Dp;

import java.util.*;

public class EggDropping {

    // Bottom-up approach for Egg Dropping Problem
    public static int eggDropBottomUp(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        // Base cases
        for (int i = 1; i <= e; i++) {
            dp[i][1] = 1; // 1 floor, 1 trial
            dp[i][0] = 0; // 0 floors, 0 trials
        }
        for (int j = 1; j <= f; j++) {
            dp[1][j] = j; // 1 egg, j floors, j trials
        }

        // Fill DP table
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        return dp[e][f];
    }

    // Top-down approach with memoization
    private static int eggDropTopDownHelper(int e, int f, int[][] memo) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        if (memo[e][f] != -1) return memo[e][f];

        int minTrials = Integer.MAX_VALUE;
        for (int x = 1; x <= f; x++) {
            int res = 1 + Math.max(
                    eggDropTopDownHelper(e - 1, x - 1, memo),
                    eggDropTopDownHelper(e, f - x, memo)
            );
            minTrials = Math.min(minTrials, res);
        }

        memo[e][f] = minTrials;
        return minTrials;
    }

    public static int eggDropTopDown(int e, int f) {
        int[][] memo = new int[e + 1][f + 1];
        for (int i = 0; i <= e; i++) {
            Arrays.fill(memo[i], -1);
        }
        return eggDropTopDownHelper(e, f, memo);
    }

    public static void main(String[] args) {
        int e = 2;   // eggs
        int f = 10;  // floors

        System.out.println("Bottom-up minimum trials: " + eggDropBottomUp(e, f));
        System.out.println("Top-down minimum trials: " + eggDropTopDown(e, f));
    }
}

