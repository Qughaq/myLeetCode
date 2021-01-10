import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));
        System.out.println(smallestStringWithSwaps(s, pairs));
    }

    static int[] group;

    public static void union(int a, int b) {
        group[find(a)] = find(group[b]);
    }

    public static int find(int a) {
        if (group[a] != a)
            group[a] = find(group[a]);
        return group[a];
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        group = new int[s.length()];
        for (int i = 0; i < group.length; i++)
            group[i] = i;
        for (List<Integer> pair : pairs)
            union(pair.get(0), pair.get(1));
        Map<Integer, Queue<Character>> groupChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            groupChar.putIfAbsent(find(i), new PriorityQueue<>());
            groupChar.get(find(i)).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            sb.append(groupChar.get(find(i)).poll());
        return sb.toString();
    }
}
