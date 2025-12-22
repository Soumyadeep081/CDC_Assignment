package Bit_Manipulation;

public class BasicOperations {
        // Count set bits (1s)
        static int countSetBits(int n) {
            int count = 0;
            while (n != 0) {
                count += (n & 1);
                n >>= 1;
            }
            return count;
        }

        // Count unset bits (assuming 32-bit integer)
        static int countUnsetBits(int n) {
            return 32 - countSetBits(n);
        }

        // Check if n is power of two
        static boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }

        // Check if n is power of four
        static boolean isPowerOfFour(int n) {
            return isPowerOfTwo(n) && (n & 0x55555555) != 0;
        }

        // Toggle k-th bit (0-based index)
        static int toggleKthBit(int n, int k) {
            return n ^ (1 << k);
        }

        // Check if k-th bit is set (0-based index)
        static boolean isNthBitSet(int n, int k) {
            return (n & (1 << k)) != 0;
        }

        public static void main(String[] args) {
            int n = 29; // 11101

            System.out.println("Number: " + n);
            System.out.println("Set bits: " + countSetBits(n));
            System.out.println("Unset bits: " + countUnsetBits(n));

            System.out.println("Is power of two (16): " + isPowerOfTwo(16));
            System.out.println("Is power of two (18): " + isPowerOfTwo(18));

            System.out.println("Is power of four (16): " + isPowerOfFour(16));
            System.out.println("Is power of four (8): " + isPowerOfFour(8));

            int k = 2;
            System.out.println("Is " + k + "th bit set in " + n + "? " + isNthBitSet(n, k));
            System.out.println("Toggle " + k + "th bit of " + n + ": " + toggleKthBit(n, k));
        }

}
