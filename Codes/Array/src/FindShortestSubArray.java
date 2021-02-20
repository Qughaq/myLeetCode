import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], new int[]{1, i, i});
            } else {
                hashMap.get(nums[i])[0]++;
                hashMap.get(nums[i])[2] = i;
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : hashMap.entrySet()) {
            int[] arr = entry.getValue();
            int thisLen = arr[2] - arr[1] + 1;
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = thisLen;
            } else if (maxNum == arr[0]) {
                minLen = Math.min(minLen, thisLen);
            }
        }
        return minLen;
    }
}
