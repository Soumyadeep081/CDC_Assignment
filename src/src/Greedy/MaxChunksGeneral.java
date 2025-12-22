package Greedy;

import java.util.*;

public class MaxChunksGeneral {
    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minRight = new int[n];

        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }

        int maxLeft = Integer.MIN_VALUE;
        int chunks = 0;

        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);
            if (i == n - 1 || maxLeft <= minRight[i + 1]) {
                chunks++;
            }
        }
        return chunks;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};
        System.out.println(maxChunksToSorted(arr));
    }
}
