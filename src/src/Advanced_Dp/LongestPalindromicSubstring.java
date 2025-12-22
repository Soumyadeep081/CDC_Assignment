package Advanced_Dp;

import java.util.*;

public class LongestPalindromicSubstring {

    // Bottom-up approach for Longest Palindromic Substring length
    public static int lpsBottomUp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;

        // Length 1 substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Length 2 substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // Length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    // Top-down approach with memoization
    private static int lpsTopDownHelper(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            int inner = lpsTopDownHelper(s, i + 1, j - 1, memo);
            if (inner == j - i - 1) {
                memo[i][j] = inner + 2;
                return memo[i][j];
            }
        }

        memo[i][j] = 0;
        return 0;
    }

    public static int lpsTopDown(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = lpsTopDownHelper(s, i, j, memo);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println("Bottom-up LPS length: " + lpsBottomUp(s));
        System.out.println("Top-down LPS length: " + lpsTopDown(s));
    }
}

