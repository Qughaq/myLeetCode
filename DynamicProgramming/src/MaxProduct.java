public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max, preMin = min;
            max = Math.max(preMax * nums[i], Math.max(nums[i], preMin * nums[i]));
            min = Math.min(preMin * nums[i], Math.min(nums[i], preMax * nums[i]));
            result = Math.max(max, result);
        }
        return result;
    }

    public static int maxProduct1(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        int[] fMax = new int[len];
        int[] fMin = new int[len];
        System.arraycopy(nums, 0, fMax, 0, len);
        System.arraycopy(nums, 0, fMin, 0, len);
        for (int i = 1; i < len; i++) {
            fMax[i] = Math.max(fMax[i - 1] * nums[i], Math.max(nums[i], fMin[i - 1] * nums[i]));
            fMin[i] = Math.min(fMin[i - 1] * nums[i], Math.min(nums[i], fMax[i - 1] * nums[i]));
        }
        int result = fMax[0];
        for (int num : fMax) {
            result = Math.max(num, result);
        }
        return result;
    }
}
