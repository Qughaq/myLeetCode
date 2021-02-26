import java.util.HashSet;

public class OriginalDigits {
    public static void main(String[] args) {
        String s = "owoztneoer";
        System.out.println(originalDigits(s));
    }

    public static String originalDigits(String s) {// building hashmap letter -> its frequency
        char[] freq = new char[26];
        for (char letter : s.toCharArray())
            freq[letter - 'a']++;

        int[] count = new int[10];
        count[0] = freq['z' - 'a'];
        count[2] = freq['w' - 'a'];
        count[4] = freq['u' - 'a'];
        count[6] = freq['x' - 'a'];
        count[8] = freq['g' - 'a'];
        count[3] = freq['h' - 'a'] - count[8];
        count[5] = freq['f' - 'a'] - count[4];
        count[7] = freq['s' - 'a'] - count[6];
        count[9] = freq['i' - 'a'] - count[5] - count[6] - count[8];
        count[1] = freq['n' - 'a'] - count[7] - 2 * count[9];

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < count[i]; j++)
                result.append(i);
        return result.toString();
    }
}
