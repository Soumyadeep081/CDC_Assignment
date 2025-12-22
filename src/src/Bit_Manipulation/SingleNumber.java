package Bit_Manipulation;

public class SingleNumber {

    // XOR-based solution
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // Main function
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        int single = singleNumber(nums);
        System.out.println("Single number: " + single);
    }
}
