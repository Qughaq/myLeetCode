public class NumDistinct {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) {
            return 0;
        }
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][tLen] = 1;
        }
        for (int i = sLen - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = tLen - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
