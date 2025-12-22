package Array2;

import java.util.*;

public class ContainerWithMostWater {

    // Brute force: check all pairs for max water area
    public static int maxWaterBF(int[] height) {
        int maxArea = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Optimized: two pointers moving inward
    public static int maxWaterOpt(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(
                    maxArea,
                    Math.min(height[left], height[right]) * (right - left)
            );

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("BF: " + maxWaterBF(h));
        System.out.println("Opt: " + maxWaterOpt(h));
    }
}
