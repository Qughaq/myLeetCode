import java.util.*;
import java.util.stream.Stream;

public class FindWords500 {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }

    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<Character> set1 = new HashSet<>();
        for (Character ch : "QWERTYUIOPqwertyuiop".toCharArray())
            set1.add(ch);
        Set<Character> set2 = new HashSet<>();
        for (Character ch : "ASDFGHJKLasdfghjkl".toCharArray())
            set2.add(ch);
        Set<Character> set3 = new HashSet<>();
        for (Character ch : "ZXCVBNMzxcvbnm".toCharArray())
            set3.add(ch);
        for (String word : words) {
            Set<Character> setTemp = new HashSet<>();
            for (Character ch : word.toCharArray())
                setTemp.add(ch);
            if (set1.containsAll(setTemp) || set2.containsAll(setTemp) || set3.containsAll(setTemp))
                result.add(word);
        }
        return result.toArray(new String[0]);
    }

    public String[] findWords2(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words)
            if (word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                result.add(word);
        return result.toArray(new String[0]);
    }
}
