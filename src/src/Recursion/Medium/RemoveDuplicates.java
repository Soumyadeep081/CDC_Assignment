package Recursion.Medium;

import java.util.*;

public class RemoveDuplicates {

    // Brute force: check in result string
    static String rmDupBF(String s) {
        String res = "";
        for (char c : s.toCharArray()) {
            if (res.indexOf(c) == -1)
                res += c;
        }
        return res;
    }

    // Optimized: HashSet
    static int removeDuplicates(int[]nums) {
        if (nums.length == 0) return 0;

        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};

        int newLength = removeDuplicates(nums);

        System.out.println("New Length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
