public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int len = nums.length;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] <= nums[i - 1])
                start = i;
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
