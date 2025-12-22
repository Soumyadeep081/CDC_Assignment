package Bit_Manipulation;

import java.util.*;

public class FindDuplicates {

    // Brute-force using HashMap (frequency counting)
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) == 2) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    // Main function
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> result = findDuplicates(nums);

        System.out.println("Duplicates: " + result);
    }
}
