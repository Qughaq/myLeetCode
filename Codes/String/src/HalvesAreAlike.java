import java.util.HashSet;

public class HalvesAreAlike {

    public static void main(String[] args) {
        String s = "bOok";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int len = s.length();
        HashSet<Character> vowels = new HashSet<>();
        char[] charArray = "aeiouAEIOU".toCharArray();
        for (char ch : charArray) {
            vowels.add(ch);
        }
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < len / 2; i++) {
            if (vowels.contains(s.charAt(i)))
                countA++;
        }
        for (int i = len / 2; i < len; i++) {
            if (vowels.contains(s.charAt(i)))
                countB++;
        }
        return countA == countB;
    }
}
