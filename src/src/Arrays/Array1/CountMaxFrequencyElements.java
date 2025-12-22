package Arrays.Array1;

import java.util.*;

public class CountMaxFrequencyElements {

    public static int countMaxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (int v : freq.values()) {
            maxFreq = Math.max(maxFreq, v);
        }

        int total = 0;
        for (int v : freq.values()) {
            if (v == maxFreq) total += v;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(countMaxFrequencyElements(nums));
    }
}
