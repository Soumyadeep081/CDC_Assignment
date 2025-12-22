package Arrays.Sort;

import java.util.*;

public class BubbleSort {

    // Brute force: bubble sort with early exit optimization
    public static void bubbleSortBF(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    // Optimized: already optimized using swapped flag
    public static void bubbleSortOpt(int[] arr) {
        bubbleSortBF(arr);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8};
        bubbleSortBF(arr1);
        System.out.print("Bubble sort BF: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        int[] arr2 = {5, 1, 4, 2, 8};
        bubbleSortOpt(arr2);
        System.out.print("Bubble sort Opt: ");
        for (int x : arr2) System.out.print(x + " ");
    }
}
