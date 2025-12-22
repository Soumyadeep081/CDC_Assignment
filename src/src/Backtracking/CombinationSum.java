package Backtracking;

import java.util.*;

public class CombinationSum {

    private static void helper(int[] arr, int target, int index,
                               List<Integer> curr,
                               List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) continue;

            curr.add(arr[i]);
            helper(arr, target - arr[i], i, curr, res); // reuse allowed
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
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
        int[] arr1 = {2, 3, 6, 7};
        System.out.println("Test Case 1:");
        print(combinationSum(arr1, 7));

        int[] arr2 = {2, 3, 5};
        System.out.println("\nTest Case 2:");
        print(combinationSum(arr2, 8));

        int[] arr3 = {2};
        System.out.println("\nTest Case 3:");
        print(combinationSum(arr3, 1));
    }
}
