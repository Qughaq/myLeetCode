import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortString1370 {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString1(s));
    }

    public static String sortString(String s) {
        int len = s.length();
        int[] freq = new int[26];
        for (int index = 0; index < len; index++) {
            freq[s.charAt(index) - 'a']++;
        }
        StringBuilder sb = new StringBuilder(len);
        int count = 0;
        while (count < len) {
            // sorting up
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] = freq[i] - 1;
                    count++;
                }
            }
            // sorting down
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] = freq[i] - 1;
                    count++;
                }
            }
        }
        return sb.toString();
    }

    public String generateTheString1(int n) {
        return IntStream.range(0, n - 1).mapToObj(i -> "a").collect(Collectors.joining("", "", String.valueOf(n % 2 != 0 ? 'a' : 'b')));
    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++)
            sb.append('a');
        sb.append(n % 2 != 0 ? 'a' : 'b');
        return sb.toString();
    }

    public static String sortString1(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        int[] frequency = new int[26];
        for (char ch : s.toCharArray())
            frequency[ch - 'a']++;
        while (count < s.length()) {
            // 上升
            for (char ch = 'a'; ch <= 'z'; ch++)
                if (frequency[ch - 'a'] > 0) {
                    result.append(ch);
                    frequency[ch - 'a']--;
                    count++;
                }
            // 下降
            for (char ch = 'z'; ch >= 'a'; ch--)
                if (frequency[ch - 'a'] > 0) {
                    result.append(ch);
                    frequency[ch - 'a']--;
                    count++;
                }
        }
        return result.toString();
    }
}
