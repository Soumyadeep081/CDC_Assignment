package Arrays.Array2;

import java.util.*;

public class FindRepeatingElement {

    // Brute force: nested loops
    public static int findRepBF(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return arr[i];
            }
        }
        return -1;
    }

    // Optimized: HashSet
    public static int findRepOpt(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int x : arr) {
            if (seen.contains(x)) return x;
            seen.add(x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 3};
        System.out.println("BF repeat: " + findRepBF(arr));
        System.out.println("Opt repeat: " + findRepOpt(arr));
    }
}
