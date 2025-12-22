package Backtracking;

import java.util.*;

public class CombinationSumII {

    private static void helper(int[] arr, int target, int start,
                               List<Integer> curr,
                               List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue; // skip duplicates
            if (arr[i] > target) break;

            curr.add(arr[i]);
            helper(arr, target - arr[i], i + 1, curr, res);
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void print(List<List<Integer>> res) {
        for (List<Integer> combo : res) {
            System.out.print("{");
            for (int i = 0; i < combo.size(); i++) {
                System.out.print(combo.get(i));
                if (i < combo.size() - 1) System.out.print(",");
            }
            System.out.print("} ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 1, 2, 7, 6, 1, 5};
        System.out.println("Test Case 1:");
        print(combinationSum2(arr1, 8));

        int[] arr2 = {2, 5, 2, 1, 2};
        System.out.println("\nTest Case 2:");
        print(combinationSum2(arr2, 5));

        int[] arr3 = {1, 1, 1, 1, 1};
        System.out.println("\nTest Case 3:");
        print(combinationSum2(arr3, 3));
    }
}
