package Advanced_Dp;


import java.util.*;

public class JumpGame {

    // Bottom-up Dynamic Programming Approach
    public static boolean canJumpBottomUp(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int j = 1; j <= nums[i] && i + j < n; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[n - 1];
    }

    // Top-down Dynamic Programming Approach (Recursive with Memoization)
    private static boolean canJumpTopDownHelper(int i, int[] nums, int[] memo) {
        if (i >= nums.length - 1) return true;
        if (memo[i] != -1) return memo[i] == 1;

        for (int j = 1; j <= nums[i]; j++) {
            if (canJumpTopDownHelper(i + j, nums, memo)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }

    public static boolean canJumpTopDown(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJumpTopDownHelper(0, nums, memo);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println("Bottom-up approach: " + canJumpBottomUp(nums));
        System.out.println("Top-down approach: " + canJumpTopDown(nums));
    }
}
