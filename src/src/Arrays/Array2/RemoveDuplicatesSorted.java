package Arrays.Array2;

public class RemoveDuplicatesSorted {

    // Brute force: create new array
    public static int rmDupBF(int[] arr) {
        if (arr.length == 0) return 0;

        int[] tmp = new int[arr.length];
        int idx = 0;

        for (int x : arr) {
            if (idx == 0 || tmp[idx - 1] != x) {
                tmp[idx++] = x;
            }
        }

        for (int i = 0; i < idx; i++) {
            arr[i] = tmp[i];
        }
        return idx;
    }

    // Optimized: two pointers (in-place)
    public static int rmDupOpt(int[] arr) {
        if (arr.length == 0) return 0;

        int idx = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[idx++] = arr[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3};
        System.out.println("BF length: " + rmDupBF(a));

        int[] b = {1, 1, 2, 2, 3};
        System.out.println("Opt length: " + rmDupOpt(b));
    }
}
