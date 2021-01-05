public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++)
            if (prices[i] < prices[i + 1])
                profit += prices[i + 1] - prices[i];
        return profit;
    }

    public static int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buy = prices[i];
            while (i < prices.length - 1 && prices[i + 1] < prices[i])
                buy = prices[++i];
            int sell = prices[i];
            while (i < prices.length - 1 && prices[i + 1] > prices[i])
                sell = prices[++i];
            profit += sell - buy;
        }
        return profit;
    }
}
