package Recursion.Medium;

import java.util.*;

public class PivotIndex {

    // Brute force
    static int pivotBF(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++) left += arr[j];
            for (int j = i + 1; j < n; j++) right += arr[j];
            if (left == right) return i;
        }
        return -1;
    }

    // Optimized: prefix sum
    static int pivotOpt(int[] nums) {
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println("BF pivot: " + pivotBF(arr));
        System.out.println("Opt pivot: " + pivotOpt(arr));
    }
}
