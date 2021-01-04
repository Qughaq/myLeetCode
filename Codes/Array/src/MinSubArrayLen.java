public class MinSubArrayLen {


    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = -1, sum = 0;
        int result = nums.length + 1;
        while (slow < nums.length) {
            if (fast < nums.length - 1 && sum < s)
                sum += nums[++fast];
            else
                sum -= nums[slow++];
            if (sum >= s)
                result = Math.min(result, fast - slow + 1);
        }
        if (result == nums.length + 1) return 0;
        return result;
    }
}
