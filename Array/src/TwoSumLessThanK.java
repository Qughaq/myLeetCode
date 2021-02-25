import java.util.Arrays;

public class TwoSumLessThanK {

    public static void main(String[] args) {
        int[] nums = {973, 478, 246, 883, 265, 900, 21, 130, 143, 235, 846, 198, 17, 964, 685, 584, 796, 329, 579, 373, 500, 944, 812, 526, 61, 318, 615, 249, 427, 449, 409, 861, 299, 429, 434, 842, 584, 33, 974, 751, 615, 463, 197, 26, 163, 143, 251, 908, 889, 252};
        int k = 900;
        System.out.println(twoSumLessThanK(nums, k));
    }


    public static int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int result = Integer.MIN_VALUE;
        while (left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum >= k) {
                right--;
            } else {
                result = Math.max(result, twoSum);
                left++;
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
