import java.util.ArrayList;
import java.util.List;

public class CountLetters {
    public static void main(String[] args) {
        String S = "aaaaaaaaaa";
        System.out.println(countLetters(S));
    }

    public static int countLetters(String S) {
        List<String> words = new ArrayList<>();
        char[] chars = S.toCharArray();
        int left = 0, right = 0;
        while (right < chars.length) {
            StringBuilder sb = new StringBuilder();
            while (right < chars.length && chars[left] == chars[right]) {
                sb.append(chars[right]);
                right++;
            }
            left = right;
            words.add(sb.toString());
        }
        int sum = 0;
        for (String word : words) {
            int len = word.length();
            sum += len * (len + 1) / 2;
        }
        return sum;
    }
}
