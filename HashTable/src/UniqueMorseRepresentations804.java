import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations804 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-",
                "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder morseWord = new StringBuilder();
            for (Character ch : word.toCharArray())
                morseWord.append(morse[ch - 'a']);
            set.add(morseWord.toString());
        }
        return set.size();
    }
}
