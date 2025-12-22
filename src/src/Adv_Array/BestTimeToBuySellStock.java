package Adv_Array;

public class BestTimeToBuySellStock {

    // Brute force: check all buy/sell pairs
    public static int maxProfitBF(int[] prices) {
        int maxP = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxP = Math.max(maxP, prices[j] - prices[i]);
            }
        }
        return maxP;
    }

    // Optimized: track minimum price so far and max profit
    public static int maxProfitOpt(int[] prices) {
        int minP = Integer.MAX_VALUE;
        int maxP = 0;

        for (int p : prices) {
            if (p < minP) {
                minP = p;
            } else {
                maxP = Math.max(maxP, p - minP);
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("BF: " + maxProfitBF(prices));
        System.out.println("Opt: " + maxProfitOpt(prices));
    }
}
