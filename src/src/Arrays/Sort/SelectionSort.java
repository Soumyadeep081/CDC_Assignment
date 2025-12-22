package Arrays.Sort;

import java.util.*;

public class SelectionSort {

    // Brute force: repeatedly find minimum and swap at front
    public static void selectionSortBF(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    // Optimized: same as brute force (selection sort has no early exit)
    public static void selectionSortOpt(int[] arr) {
        selectionSortBF(arr);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11};
        selectionSortBF(arr1);
        System.out.print("Selection sort BF: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        int[] arr2 = {64, 25, 12, 22, 11};
        selectionSortOpt(arr2);
        System.out.print("Selection sort Opt: ");
        for (int x : arr2) System.out.print(x + " ");
    }
}

