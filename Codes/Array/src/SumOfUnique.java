import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class SumOfUnique {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(sumOfUnique(nums));
    }

    public static int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public static int sumOfUnique1(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                sum += key;
            }
        }
        return sum;
    }
}
