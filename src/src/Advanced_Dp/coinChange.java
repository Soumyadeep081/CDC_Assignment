package Advanced_Dp;
import java.util.*;

public class coinChange {

    // Bottom-up Dynamic Programming Approach
    public static int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Top-down Dynamic Programming Approach (Recursive with Memoization)
    private static int coinChangeTopDownHelper(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != -2) return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeTopDownHelper(coins, amount - coin, memo);
            if (res != -1) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        memo[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[amount];
    }

    public static int coinChangeTopDown(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return coinChangeTopDownHelper(coins, amount, memo);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Bottom-up approach: " + coinChangeBottomUp(coins, amount));
        System.out.println("Top-down approach: " + coinChangeTopDown(coins, amount));
    }
}
