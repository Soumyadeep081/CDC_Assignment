package Bit_Manipulation;
public class CountSetBits {

    // Brute force: use built-in bit count
    static int countBitsBF(int n) {
        return Integer.bitCount(n);
    }

    // Optimized: Brian Kernighan's Algorithm
    static int countBitsOpt(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // remove lowest set bit
            count++;
        }
        return count;
    }

    // Main function
    public static void main(String[] args) {
        int n = 29; // binary: 11101

        System.out.println("Number: " + n);
        System.out.println("Set bits (BF): " + countBitsBF(n));
        System.out.println("Set bits (Opt): " + countBitsOpt(n));
    }
}
