package Arrays.Array3;

public class MaximumSubarray {

    // Brute force
    public static int maxSubBF(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Optimized (Kadane’s Algorithm)
    public static int maxSubOpt(int[] arr) {
        int maxEnding = 0, maxSoFar = Integer.MIN_VALUE;
        for (int x : arr) {
            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        return maxSoFar;
    }
}
