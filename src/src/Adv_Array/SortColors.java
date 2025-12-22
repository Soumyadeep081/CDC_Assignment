package Adv_Array;

public class SortColors {

    // Brute force: count 0s, 1s, 2s and overwrite array
    public static void sortColorsBF(int[] arr) {
        int c0 = 0, c1 = 0, c2 = 0;

        for (int x : arr) {
            if (x == 0) c0++;
            else if (x == 1) c1++;
            else c2++;
        }

        int i = 0;
        while (c0-- > 0) arr[i++] = 0;
        while (c1-- > 0) arr[i++] = 1;
        while (c2-- > 0) arr[i++] = 2;
    }

    // Optimized: three pointers (Dutch National Flag)
    public static void sortColorsOpt(int[] arr) {
        int l = 0, m = 0, h = arr.length - 1;

        while (m <= h) {
            if (arr[m] == 0) {
                swap(arr, l++, m++);
            } else if (arr[m] == 1) {
                m++;
            } else {
                swap(arr, m, h--);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};

        sortColorsOpt(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
