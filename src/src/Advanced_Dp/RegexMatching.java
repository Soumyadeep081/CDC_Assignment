package Advanced_Dp;

import java.util.*;


// Top-down approach (Memoization)
class SolutionTopDown {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(0, 0, s, p, memo);
    }

    private boolean helper(int i, int j, String s, String p, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j] == 1;

        boolean ans;
        if (j == p.length()) {
            ans = (i == s.length());
        } else {
            boolean firstMatch =
                    (i < s.length() &&
                            (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = helper(i, j + 2, s, p, memo) ||
                        (firstMatch && helper(i + 1, j, s, p, memo));
            } else {
                ans = firstMatch && helper(i + 1, j + 1, s, p, memo);
            }
        }

        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}


// Bottom-up approach (Tabulation)
class SolutionBottomUp {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Patterns like a*, a*b*, etc. matching empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // zero occurrence
                    dp[i][j] = dp[i][j - 2];

                    // one or more occurrences
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == s.charAt(i - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}


// Driver
public class RegexMatching {
    public static void main(String[] args) {
        SolutionTopDown topDown = new SolutionTopDown();
        SolutionBottomUp bottomUp = new SolutionBottomUp();

        String s = "aa";
        String p = "a*";

        System.out.println("Top-down result: " + topDown.isMatch(s, p));
        System.out.println("Bottom-up result: " + bottomUp.isMatch(s, p));
    }
}
