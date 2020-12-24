import java.util.HashMap;
import java.util.HashSet;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = {"abc", "edf", "xyz"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        HashMap<Integer, Character> hashMap = new HashMap<>();
        int lastIndex = 0;
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                if (hashMap.containsKey(i) && hashMap.get(i) != str.charAt(i)) {
                    lastIndex = i;
                    break;
                }
                hashMap.put(i, str.charAt(i));
            }
        }
        return strs[0].substring(0, lastIndex);
    }
}
