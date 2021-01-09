import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static void main(String[] args) {
        String pattern = "aaa", str = "aa aa aa";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        String[] split = s.split(" ");
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);
            if (i >= split.length)
                return false;
            if (str2ch.containsKey(split[i]) && !str2ch.get(split[i]).equals(ch))
                return false;
            if (ch2str.containsKey(ch) && !ch2str.get(ch).equals(split[i]))
                return false;
            str2ch.put(split[i], ch);
            ch2str.put(ch, split[i]);
            i++;
        }
        return i >= split.length;
    }
}
