import com.sun.tools.javac.util.ArrayUtils;


import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons1189 {
    public static void main(String[] args) {
        String text = "llllleetcode";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : text.toCharArray())
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n')
                map.put(ch, map.getOrDefault(ch, 0) + 1);
        int count = Integer.MAX_VALUE;
        for (Character ch : "blaon".toCharArray())
            if (!map.containsKey(ch))
                return 0;
            else if (map.containsKey('l') && map.containsKey('o')) {
                count = ch != 'l' ? Math.min(count, map.get(ch)) : Math.min(count, map.get('l') / 2);
                count = ch != 'o' ? Math.min(count, map.get(ch)) : Math.min(count, map.get('o') / 2);
            }
        return count;
    }
}
