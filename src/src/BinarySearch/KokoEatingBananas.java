package BinarySearch;

import java.util.*;

public class KokoEatingBananas {

    // Check if Koko can finish with speed k
    private static boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil division
        }
        return hours <= h;
    }

    // Brute force
    public static int minEatingSpeedBF(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        for (int k = 1; k <= maxPile; k++) {
            if (canFinish(piles, h, k)) return k;
        }
        return maxPile;
    }

    // Optimized: binary search
    public static int minEatingSpeedOpt(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println("BF: " + minEatingSpeedBF(piles, 8));
        System.out.println("Opt: " + minEatingSpeedOpt(piles, 8));
    }
}

