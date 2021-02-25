import java.util.Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static int maximumProduct2(int[] nums) {
        int result;
        Arrays.sort(nums);
        int len = nums.length;
        int max1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int max2 = nums[0] * nums[1] * nums[len - 1];
        result = Math.max(max1, max2);
        return result;
    }
}
