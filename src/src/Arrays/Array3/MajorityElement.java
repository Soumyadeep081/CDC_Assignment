package Arrays.Array3;

import java.util.*;

public class MajorityElement {

    // Brute force using HashMap
    public static int majBF(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = -1, maxC = 0;

        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxC) {
                maxC = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }

    // Optimized (Moore’s Voting Algorithm)
    public static int majOpt(int[] arr) {
        int count = 0, candidate = -1;
        for (int x : arr) {
            if (count == 0) candidate = x;
            count += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
