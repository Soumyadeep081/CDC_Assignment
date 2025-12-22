package Bit_Manipulation;

public class MissingNumber {

    // XOR-based solution
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xorAll = 0;

        // XOR of 0..n
        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }

        // XOR with all elements in array
        for (int num : nums) {
            xorAll ^= num;
        }

        return xorAll;
    }

    // Main function
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};

        int missing = missingNumber(nums);
        System.out.println("Missing number: " + missing);
    }
}
