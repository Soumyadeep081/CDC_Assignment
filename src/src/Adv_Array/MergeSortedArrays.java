package Adv_Array;

import java.util.*;

public class MergeSortedArrays {

    // Brute force: merge then sort
    public static int[] mergeSortedBF(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int idx = 0;

        for (int x : a) res[idx++] = x;
        for (int x : b) res[idx++] = x;

        Arrays.sort(res);
        return res;
    }

    // Optimized: merge two sorted arrays in O(n + m)
    public static int[] mergeSortedOpt(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < a.length) {
            res[k++] = a[i++];
        }

        while (j < b.length) {
            res[k++] = b[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] res = mergeSortedOpt(a, b);
        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
