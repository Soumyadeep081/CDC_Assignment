package Arrays.Array2;

public class FindElement {

    // Brute force: linear search
    public static int findElemBF(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // Optimized: same for unsorted array
    public static int findElemOpt(int[] arr, int x) {
        return findElemBF(arr, x);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1};
        System.out.println("BF Index: " + findElemBF(arr, 7));
        System.out.println("Opt Index: " + findElemOpt(arr, 7));
    }
}
