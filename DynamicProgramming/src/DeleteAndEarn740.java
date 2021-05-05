public class DeleteAndEarn740 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] sum = new int[maxNum + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    private static int rob(int[] nums) {
        int len = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
