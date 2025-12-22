package Advanced_Dp;
import java.util.*;

public class CountingBits {

    // Top-down approach (Recursion with Memoization)
    private static List<Integer> countBitsTopDown(int n, int[] memo) {
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList(0));
        }
        if (memo[n] != -1) {
            return new ArrayList<>(Collections.singletonList(memo[n]));
        }

        List<Integer> prev = countBitsTopDown(n - 1, memo);
        int bits = Integer.bitCount(n);
        memo[n] = bits;
        prev.add(bits);
        return prev;
    }

    // Bottom-up approach (Iterative DP)
    private static List<Integer> countBitsBottomUp(int n) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, 0));
        for (int i = 1; i <= n; i++) {
            dp.set(i, dp.get(i >> 1) + (i & 1));
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // Top-down
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        List<Integer> resultTopDown = countBitsTopDown(n, memo);
        System.out.print("Top-down result: ");
        for (int val : resultTopDown) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Bottom-up
        List<Integer> resultBottomUp = countBitsBottomUp(n);
        System.out.print("Bottom-up result: ");
        for (int val : resultBottomUp) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
