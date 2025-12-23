package HashMap.Hashmap2;

import java.util.*;

public class MissingNumber {

    // Brute Force
    static int missingNumberBF(int[] nums, int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int x : nums) {
                if (x == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }

    // Optimized using sum formula
    static int missingNumberOpt(int[] nums, int n) {
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int x : nums) sum += x;
        return total - sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        int n = 5;

        System.out.println("BF: " + missingNumberBF(nums, n));
        System.out.println("Opt: " + missingNumberOpt(nums, n));
    }
}
