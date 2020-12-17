import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static void main(String[] args) {
        String pattern = "aaa", str = "aa aa aa aa";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        String[] strings = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map1.containsKey(c) && !map1.get(c).equals(strings[i]))
                return false;
            else {
                if (!map1.containsKey(c) && map1.containsValue(strings[i]))
                    return false;
                else
                    map1.put(c, strings[i]);
            }
        }
        return true;
    }
}
