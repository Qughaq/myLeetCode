import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        int result = 0;
        for (int i = 1; i <= 26; i++) {
            int left = 0, right = 0;
            int[] charsFreq = new int[26];
            int total = 0;
            int less = 0;
            while (right < s.length()) {
                charsFreq[s.charAt(right) - 'a']++;
                if (charsFreq[s.charAt(right) - 'a'] == 1) {
                    total++;
                    less++;
                }
                if (charsFreq[s.charAt(right) - 'a'] == k)
                    less--;

                while (total > i) {
                    charsFreq[s.charAt(left) - 'a']--;
                    if (charsFreq[s.charAt(left) - 'a'] == k - 1)
                        less++;
                    if (charsFreq[s.charAt(left) - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    left++;
                }
                if (less == 0)
                    result = Math.max(result, right - left + 1);
                right++;
            }
        }
        return result;
    }
}
