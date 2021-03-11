import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition131 {
    boolean[][] f;
    List<List<String>> result = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int len;

    public List<List<String>> partition(String s) {
        len = s.length();
        f = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return result;
    }

    public void dfs(String s, int i) {
        if (i == len) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < len; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
