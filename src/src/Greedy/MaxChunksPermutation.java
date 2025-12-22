package Greedy;

public class MaxChunksPermutation {
    public static int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0, chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }
        return chunks;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
        System.out.println(maxChunksToSorted(arr));
    }
}

