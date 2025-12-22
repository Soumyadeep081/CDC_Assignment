package Array2;

import java.util.*;

public class TwoSum {

    // Brute force: check all pairs for target sum
    public static boolean twoSumBF(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimized: use HashSet to find complement in O(n)
    public static boolean twoSumOpt(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int x : arr) {
            int c = target - x;
            if (seen.contains(c)) {
                return true;
            }
            seen.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};

        System.out.println(twoSumBF(a, 9) ? "BF: true" : "BF: false");
        System.out.println(twoSumOpt(a, 9) ? "Opt: true" : "Opt: false");
    }
}
