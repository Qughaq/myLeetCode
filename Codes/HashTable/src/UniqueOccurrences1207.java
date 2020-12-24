import java.util.*;

public class UniqueOccurrences1207 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences2(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : arr)
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        Collection<Integer> values = hashMap.values();
        Set<Integer> set = new HashSet<>();
        for (Integer integer : values) {
            if (set.contains(integer))
                return false;
            set.add(integer);
        }
        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : arr)
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        return hashMap.size() == new HashSet<>(hashMap.values()).size();
    }
}
