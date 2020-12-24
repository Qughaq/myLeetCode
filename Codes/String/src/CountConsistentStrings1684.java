import java.util.HashSet;

public class CountConsistentStrings1684 {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ab", "bd", "aaab", "baa", "badab"};
        System.out.println(countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (Character ch : allowed.toCharArray())
            set.add(ch);
        for (String word : words) {
            int temp = 0;
            for (Character ch : word.toCharArray())
                if (set.contains(ch))
                    temp++;
            if (temp == word.length())
                count++;
        }
        return count;
    }
}
