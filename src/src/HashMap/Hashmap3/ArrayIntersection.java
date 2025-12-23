package HashMap.Hashmap3;

import java.util.*;

public class ArrayIntersection {

    // Brute Force
    static List<Integer> intersectionBF(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        boolean[] used = new boolean[nums2.length];

        for (int x : nums1) {
            for (int i = 0; i < nums2.length; i++) {
                if (!used[i] && nums2[i] == x) {
                    res.add(x);
                    used[i] = true;
                    break;
                }
            }
        }
        return res;
    }

    // Optimized using HashMap
    static List<Integer> intersectionOpt(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums1)
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for (int x : nums2) {
            if (freq.getOrDefault(x, 0) > 0) {
                res.add(x);
                freq.put(x, freq.get(x) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        int[] b = {2, 2};

        System.out.println(intersectionOpt(a, b));
    }
}
