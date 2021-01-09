public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 对于任意一天考虑四个变量:
     * fstBuy: 在该天第一次买入股票可获得的最大收益
     * fstSell: 在该天第一次卖出股票可获得的最大收益
     * secBuy: 在该天第二次买入股票可获得的最大收益
     * secSell: 在该天第二次卖出股票可获得的最大收益
     * 分别对四个变量进行相应的更新, 最后secSell就是最大
     * 收益值(secSell >= fstSell)
     **/
    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }


    public static int maxProfit2(int[] prices) {
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
