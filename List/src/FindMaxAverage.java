import java.util.Arrays;

public class FindMaxAverage {
    public static void main(String[] args) {
        int[] nums = {0, 4, 0, 3, 2};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = Arrays.stream(nums, 0, k).sum();
        int maxSum = sum;
        for (int i = 0; i < len - k; i++) {
            sum = sum - nums[i] + nums[i + k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        int len = nums.length;
        int sum = Arrays.stream(nums, 0, k).sum();
        double average = sum * 1.0 / k;
        for (int i = 0; i < len - k; i++) {
            sum -= nums[i];
            sum += nums[i + k];
            average = Math.max(average, sum * 1.0 / k);
        }
        return average;
    }
}
