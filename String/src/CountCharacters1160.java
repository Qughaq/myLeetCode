import java.util.Arrays;
import java.util.HashMap;

public class CountCharacters1160 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters2(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        HashMap<Character, Integer> CharsMap = new HashMap<>();
        for (Character ch : chars.toCharArray())
            CharsMap.put(ch, CharsMap.getOrDefault(ch, 0) + 1);
        for (String word : words) {
            HashMap<Character, Integer> wordMap = new HashMap<>();
            for (Character ch : word.toCharArray())
                wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
            int counter = 0;
            for (Character ch : word.toCharArray())
                if (CharsMap.containsKey(ch) && wordMap.get(ch) <= CharsMap.get(ch))
                    counter++;
            if (counter == word.length())
                result += counter;
        }
        return result;
    }

    public static int countCharacters2(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
        for (String word : words) {
            int[] tempSeen = Arrays.copyOf(seen, seen.length);
            int tempCount = 0;
            for (char c : word.toCharArray())
                if (tempSeen[c - 'a'] > 0) {
                    tempSeen[c - 'a']--;
                    tempCount++;
                }
            if (tempCount == word.length())
                count += tempCount;
        }
        return count;
    }
}
