import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        //按照宽度w升序，再按照高度h降序排序
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int m = envelopes.length;
        int[] f = new int[m];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
