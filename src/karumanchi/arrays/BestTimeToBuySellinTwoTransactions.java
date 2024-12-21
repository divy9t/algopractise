package karumanchi.arrays;

public class BestTimeToBuySellinTwoTransactions {
    public static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        performLogic(prices);
    }

    private static void performLogic(int[] prices) {
        int minPrice = prices[0];
        int[] firstPassProfit = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            firstPassProfit[i] = Math.max(firstPassProfit[i-1], prices[i] - minPrice);
        }

        int maxPrice = prices[prices.length -1];
        int[] secondPassProfit = new int[prices.length];

        for (int i = prices.length - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            secondPassProfit[i] = Math.max(secondPassProfit[i+1], maxPrice - prices[i]);
        }

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(firstPassProfit[i] + secondPassProfit[i], maxProfit);
        }

        System.out.println(maxProfit);

    }
}
