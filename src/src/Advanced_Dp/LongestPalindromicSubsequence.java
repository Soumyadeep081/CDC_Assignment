package Advanced_Dp;
import java.util.*;

public class LongestPalindromicSubsequence {

    // Bottom-up approach for Longest Palindromic Subsequence
    public static int lpsBottomUp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Single characters
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Lengths 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    // Top-down approach with memoization
    private static int lpsTopDownHelper(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + lpsTopDownHelper(s, i + 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(
                    lpsTopDownHelper(s, i + 1, j, memo),
                    lpsTopDownHelper(s, i, j - 1, memo)
            );
        }
        return memo[i][j];
    }

    public static int lpsTopDown(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return lpsTopDownHelper(s, 0, n - 1, memo);
    }

    public static void main(String[] args) {
        String s = "bbbab";

        System.out.println("Bottom-up LPS length: " + lpsBottomUp(s));
        System.out.println("Top-down LPS length: " + lpsTopDown(s));
    }
}
