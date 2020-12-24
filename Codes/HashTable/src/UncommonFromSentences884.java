import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences884 {
    public static void main(String[] args) {
        String A = "this apple apple is sweet";
        String B = "this apple is sweet sour";
        System.out.println(Arrays.toString(uncommonFromSentences(A, B)));
    }

    public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = (A + " " + B).split(" ");
        for (String str : split)
            map.put(str, map.getOrDefault(str, 0) + 1);
        List<String> result = new ArrayList<>();
        for (String str : map.keySet())
            if (map.get(str) == 1)
                result.add(str);
        return result.toArray(new String[0]);
    }

    public static String[] uncommonFromSentences1(String A, String B) {
        String[] splitA = A.split(" ");
        String[] splitB = B.split(" ");
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for (String str : splitA)
            mapA.put(str, mapA.getOrDefault(str, 0) + 1);
        for (String str : splitB)
            mapB.put(str, mapB.getOrDefault(str, 0) + 1);
        List<String> result = new ArrayList<>();
        for (String str : splitA)
            if (mapA.get(str) == 1 && !mapB.containsKey(str))
                result.add(str);
        for (String str : splitB)
            if (mapB.get(str) == 1 && !mapA.containsKey(str))
                result.add(str);
        return result.toArray(new String[0]);
    }
}
