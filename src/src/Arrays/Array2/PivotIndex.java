package Arrays.Array2;

public class PivotIndex {

    // Brute force: sum left and right for each index
    public static int pivotBF(int[] arr) {
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
    public static int pivotOpt(int[] arr) {
        int total = 0;
        for (int x : arr) total += x;

        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left == total - left - arr[i]) return i;
            left += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println("BF pivot: " + pivotBF(arr));
        System.out.println("Opt pivot: " + pivotOpt(arr));
    }
}

