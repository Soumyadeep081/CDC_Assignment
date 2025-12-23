package HashMap.Hashmap1;

import java.util.*;

public class LongestConsecutiveSequence {

    // Brute force
    public static int longestBF(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1, curr = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) curr++;
            else if (nums[i] != nums[i - 1]) curr = 1;
            longest = Math.max(longest, curr);
        }
        return longest;
    }

    // Optimized
    public static int longestOpt(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int len = 1;
                while (set.contains(n + len)) len++;
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("BF: " + longestBF(nums.clone()));
        System.out.println("Opt: " + longestOpt(nums));
    }
}
