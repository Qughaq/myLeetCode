public class Fib509 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(fib3(n));
    }

    // 递归
    public static int fib1(int n) {
        if (n < 2) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    // 带有备忘录的递归
    public static int fib(int n) {
        if (n < 2) return n;
        int[] memo = new int[n + 1];
        return memoHelper(memo, n);
    }

    private static int memoHelper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = memoHelper(memo, n - 1) + memoHelper(memo, n - 2);
        return memo[n];
    }

    // 数组的迭代解法
    public static int fib5(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 动态规划1
    public static int fib3(int n) {
        if (n < 2) return n;
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    // 动态规划2
    public static int fib6(int n) {
        int first = 0;
        int second = 1;
        while (n > 0) {
            int temp = first + second;
            first = second;
            second = temp;
            n--;
        }
        return first;
    }

    // 按公式计算
    public static int fib2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }
}
