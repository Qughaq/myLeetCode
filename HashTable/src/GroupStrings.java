import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupStrings {
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupStrings(strings));
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            String hashed = IntStream.range(1, string.length()).mapToObj(i -> String.valueOf((chars[i] - chars[i - 1] + 26) % 26)).collect(Collectors.joining());
            if (!map.containsKey(hashed))
                map.put(hashed, new ArrayList<>());
            List<String> list = map.get(hashed);
            list.add(string);
        }
        return map.keySet().stream().map(map::get).collect(Collectors.toList());
    }

    public static List<List<String>> groupStrings1(String[] strings) {
        if (strings == null || strings.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                int shift = (c - str.charAt(0) + 26) % 26;
                sb.append(shift);
            }
            String key = sb.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
