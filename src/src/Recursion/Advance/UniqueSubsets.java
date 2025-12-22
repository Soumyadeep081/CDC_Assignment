package Recursion.Advance;

import java.util.*;

public class UniqueSubsets {

    // Helper method for backtracking
    static void uniqueSubsetsHelper(int[] nums, int index,
                                    List<Integer> curr,
                                    List<List<Integer>> res) {

        // Add current subset
        res.add(new ArrayList<>(curr));

        // Try including remaining numbers
        for (int i = index; i < nums.length; i++) {

            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            // Include nums[i]
            curr.add(nums[i]);

            // Recurse
            uniqueSubsetsHelper(nums, i + 1, curr, res);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }

    // Main function to generate unique subsets
    static List<List<Integer>> uniqueSubsets(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        List<List<Integer>> res = new ArrayList<>();
        uniqueSubsetsHelper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    // Helper function to print subsets
    static void printSubsets(List<List<Integer>> subsets) {
        System.out.print("{ ");
        for (List<Integer> subset : subsets) {
            System.out.print("{");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1) System.out.print(",");
            }
            System.out.print("} ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {

        // Test Case 1
        System.out.println("Test Case 1: [1,2,2]");
        int[] nums1 = {1, 2, 2};
        printSubsets(uniqueSubsets(nums1));

        // Test Case 2
        System.out.println("\nTest Case 2: [1,1,1]");
        int[] nums2 = {1, 1, 1};
        printSubsets(uniqueSubsets(nums2));

        // Test Case 3
        System.out.println("\nTest Case 3: [1,2,3]");
        int[] nums3 = {1, 2, 3};
        printSubsets(uniqueSubsets(nums3));
    }
}
