package BinarySearch;
public class LowerBound {

    // Brute force
    public static int lowerBoundBF(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) return i;
        }
        return -1;
    }

    // Optimized: binary search
    public static int lowerBoundOpt(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l < arr.length ? l : -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 4, 5, 7};
        System.out.println("BF: " + lowerBoundBF(a, 4));
        System.out.println("Opt: " + lowerBoundOpt(a, 4));
    }
}
