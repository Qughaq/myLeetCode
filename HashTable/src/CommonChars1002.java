import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonChars1002 {
    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        System.out.println(commonChars(A));
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] subCount = new int[26];
            str.chars().forEach(character -> subCount[character - 'a']++);
            for (int i = 0; i < 26; i++)
                count[i] = Math.min(subCount[i], count[i]);
        }
        for (char character = 'a'; character <= 'z'; character++)
            while (count[character - 'a']-- > 0)
                result.add("" + character);
        return result;
    }
}
