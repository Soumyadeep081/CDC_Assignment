package Arrays.Array1;

public class FindMinMax {

    public static int[] findMinMax(int[] nums) {
        int minVal = nums[0], maxVal = nums[0];

        for (int val : nums) {
            if (val < minVal) minVal = val;
            if (val > maxVal) maxVal = val;
        }
        return new int[]{minVal, maxVal};
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        int[] res = findMinMax(nums);
        System.out.println("Minimum: " + res[0] + ", Maximum: " + res[1]);
    }
}
