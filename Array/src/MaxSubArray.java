import sun.security.util.ArrayUtil;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    // 动态规划
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];

            maxSum = Math.max(maxSum, nums[i]);
        }
        return Math.max(nums[0], maxSum);
    }

    // 贪心算法，复杂度为O(n)
    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num, num + sum);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // 复杂度为O(n^2)
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
