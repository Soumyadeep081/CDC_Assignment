package Bit_Manipulation;

public class SingleNumberII {

    // Bit-counting solution where every element appears 3 times except one
    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            sum %= 3;
            if (sum != 0) {
                result |= (sum << i);
            }
        }
        return result;
    }

    // Main function
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};

        int unique = singleNumber(nums);
        System.out.println("Single number: " + unique);
    }
}
