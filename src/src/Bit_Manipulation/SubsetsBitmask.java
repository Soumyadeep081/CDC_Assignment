package Bit_Manipulation;

import java.util.*;

public class SubsetsBitmask {

    // Generate all subsets using bitmasking
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            res.add(subset);
        }
        return res;
    }

    // Main function
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> allSubsets = subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
