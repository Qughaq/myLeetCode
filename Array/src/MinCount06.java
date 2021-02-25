import java.util.Arrays;

public class MinCount06 {
    public static void main(String[] args) {
        int[] coins = {4, 2, 1};
        System.out.println(minCount(coins));
    }
    public static int minCount(int[] coins) {
        return Arrays.stream(coins).map(coin -> (coin + 1) / 2).sum();
    }
    public static int minCount1(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += (coin + 1) / 2;
        }
        return count;
    }
    public int minCount2(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            if (coin % 2 == 0) count += coin / 2;
            else count += coin / 2 + 1;
        }
        return count;
    }
}
