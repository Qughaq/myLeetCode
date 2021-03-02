public class MaxSumDivThree {
    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }

    public static int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] dp2 = {0, 0, 0};
            for (int i = 0; i < 3; i++) {
                dp2[(i + num) % 3] = Math.max(dp[(i + num) % 3], dp[i] + num);
            }
            dp = dp2;
        }
        return dp[0];
    }
}
