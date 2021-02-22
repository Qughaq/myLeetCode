import java.util.TreeMap;

public class LongestSubarray {
    public static void main(String[] args) {

        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0, result = 0;
        while (right < nums.length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
