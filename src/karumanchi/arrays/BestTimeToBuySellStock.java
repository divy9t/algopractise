package karumanchi.arrays;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    private static Integer maxProfit(int[] arr) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int j : arr) {
            if (j < minPrice) {
                minPrice = j;
            } else if ((j - minPrice) > maxProfit) {
                maxProfit = j - minPrice;
            }
        }

        return maxProfit;
    }
}
