package Arrays.Array3;

public class MaximumProductSubarray {

    // Brute force
    public static int maxProdBF(int[] arr) {
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;
    }

    // Optimized
    public static int maxProdOpt(int[] arr) {
        int maxP = arr[0], minP = arr[0], res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int tmp = maxP;
                maxP = minP;
                minP = tmp;
            }
            maxP = Math.max(arr[i], maxP * arr[i]);
            minP = Math.min(arr[i], minP * arr[i]);
            res = Math.max(res, maxP);
        }
        return res;
    }
}

