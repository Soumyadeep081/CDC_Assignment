package Advanced_Dp;
import java.util.*;

public class LCS {

    // Bottom-up approach for Longest Common Subsequence
    public static int lcsBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // Top-down approach with memoization
    private static int lcsTopDownHelper(String s1, String s2, int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            memo[i][j] = 1 + lcsTopDownHelper(s1, s2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(
                    lcsTopDownHelper(s1, s2, i - 1, j, memo),
                    lcsTopDownHelper(s1, s2, i, j - 1, memo)
            );
        }
        return memo[i][j];
    }

    public static int lcsTopDown(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcsTopDownHelper(s1, s2, m, n, memo);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println("Bottom-up LCS length: " + lcsBottomUp(s1, s2));
        System.out.println("Top-down LCS length: " + lcsTopDown(s1, s2));
    }
}
