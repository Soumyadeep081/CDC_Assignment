package Arrays.Sort;

import java.util.*;

public class InsertionSort {

    // Brute force: insert elements in sorted order by shifting
    public static void insertionSortBF(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Optimized: same logic, best case O(n)
    public static void insertionSortOpt(int[] arr) {
        insertionSortBF(arr);
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6};
        insertionSortBF(arr1);
        System.out.print("Insertion sort BF: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        int[] arr2 = {12, 11, 13, 5, 6};
        insertionSortOpt(arr2);
        System.out.print("Insertion sort Opt: ");
        for (int x : arr2) System.out.print(x + " ");
    }
}
