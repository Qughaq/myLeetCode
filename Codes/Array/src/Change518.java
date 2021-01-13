public class Change518 {
    public static void main(String[] args) {
        int amount = 10000;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = coin; i < amount + 1; i++)
                dp[i] += dp[i - coin];
        return dp[amount];
    }
}
