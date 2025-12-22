package Recursion.Easy;

public class ArraySum {

    // Brute force: iterative sum
    static int sumArrBF(int[] arr) {
        int res = 0;
        for (int x : arr) res += x;
        return res;
    }

    // Optimized: recursive sum
    static int sumArrOpt(int[] arr, int idx) {
        if (idx == arr.length) return 0;
        return arr[idx] + sumArrOpt(arr, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("BF: " + sumArrBF(arr));
        System.out.println("Opt: " + sumArrOpt(arr, 0));
    }
}
