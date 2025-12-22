package BinarySearch;

import java.util.*;

public class AggressiveCows {

    // Brute force feasibility check
    private static boolean canPlace(int[] stalls, int cows, int dist) {
        int count = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
                if (count == cows) return true;
            }
        }
        return false;
    }

    // Brute force: try all distances
    public static int aggressiveCowsBF(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int maxDist = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        for (int d = 1; d <= maxDist; d++) {
            if (canPlace(stalls, cows, d)) ans = d;
        }
        return ans;
    }

    // Optimized: binary search on distance
    public static int aggressiveCowsOpt(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int left = 1;
        int right = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int count = 1;
            int last = stalls[0];
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - last >= mid) {
                    count++;
                    last = stalls[i];
                    if (count >= cows) break;
                }
            }

            if (count >= cows) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9};
        System.out.println("BF: " + aggressiveCowsBF(stalls.clone(), 3));
        System.out.println("Opt: " + aggressiveCowsOpt(stalls.clone(), 3));
    }
}
