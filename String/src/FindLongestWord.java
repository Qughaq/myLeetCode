import java.util.Arrays;
import java.util.HashSet;

public class FindLongestWord {
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(findLongestWord(words));
    }

    public static String findLongestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> built = new HashSet<>();
        String result = "";
        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > result.length())
                    result = word;
                built.add(word);
            }
        }
        return result;
    }
}
