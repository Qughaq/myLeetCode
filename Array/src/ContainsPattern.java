import java.util.HashMap;

public class ContainsPattern {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,1,1,3};
        int m = 2, k = 2;
        System.out.println(containsPattern(arr, m, k));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < m; j++) {
                freqMap.put(j, freqMap.getOrDefault(j, 0) + 1);
            }
            int x = 10;
        }
        return false;
    }
}
