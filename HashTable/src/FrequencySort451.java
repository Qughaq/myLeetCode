import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort451 {
    public static void main(String[] args) {
        String words = "trxyzeeaaddbbbbb";
        System.out.println(frequencySort1(words));
    }

    public static String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq;
        pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < e.getValue(); i++)
                result.append(e.getKey());
        }
        return result.toString();
    }

    public static String frequencySort2(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, new int[]{1, i});
            else {
                int[] freqAndSeq = map.get(ch);
                freqAndSeq[0]++;
                map.put(ch, freqAndSeq);
            }
        }
        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) ->
                a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]);
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, int[]> e = pq.poll();
            for (int i = 0; i < e.getValue()[0]; i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char ch : s.toCharArray())
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char key : hashMap.keySet()) {
            int frequency = hashMap.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char ch : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(ch);
        return sb.toString();
    }
}
