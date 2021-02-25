import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MostCommonWord819 {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        int maxFreq = 0;
        char[] chars = paragraph.toCharArray();
        HashMap<String, Integer> freqMap = new HashMap<>();
        HashSet<String> banSet = new HashSet<>(Arrays.asList(banned));
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            while (i < chars.length && Character.isLetter(chars[i])) {
                sb.append(Character.toLowerCase(chars[i]));
                i++;
            }
            String word = sb.toString();
            if (word.length() > 0 && !banSet.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                maxFreq = Math.max(maxFreq, freqMap.get(word));
            }
        }
        for (String key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq) {
                return key;
            }
        }
        return null;
    }
}
