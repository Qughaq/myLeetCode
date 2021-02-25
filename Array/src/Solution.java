import java.util.HashMap;

public class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer, Integer> mostLanguage = new HashMap<>();
        HashMap<Integer, Integer> notConnected = new HashMap<>();
        // 记录没有共同语言的好友
        for (int[] friendship : friendships) {
            if (!hasCommon(languages, friendship[0], friendship[1])) {
                notConnected.put(friendship[0], notConnected.getOrDefault(friendship[0], 0) + 1);
                notConnected.put(friendship[1], notConnected.getOrDefault(friendship[1], 0) + 1);
            }
        }
        // 统计他们会的语言
        for (Integer key : notConnected.keySet()) {
            for (int language : languages[key - 1]) {
                mostLanguage.put(language, mostLanguage.getOrDefault(language, 0) + 1);
            }
        }
        // 找到他们里最通用的语言
        final int[] most = new int[1];
        for (Integer value : mostLanguage.values()) {
            most[0] = Math.max(value, most[0]);
        }
        // 需要再学习该语言的人数，他们的总人数-会该语言的人数
        int nodes = notConnected.size();
        return nodes - most[0];
    }

    private boolean hasCommon(int[][] languages, int i, int j) {
        // 判断两人是否有共同语言
        int[] lv1 = languages[i - 1];
        int[] lv2 = languages[j - 1];
        for (int l1 : lv1)
            for (int l2 : lv2)
                if (l1 == l2)
                    return true;
        return false;
    }
}
