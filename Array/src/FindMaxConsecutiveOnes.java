public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int slow = -1;
        for (int fast = 0; fast < nums.length; fast++)
            if (nums[fast] == 1)
                max = Math.max(max, fast - slow);
            else
                slow = fast;
        return max;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int s = 0;
        for (int num : nums)
            if (num == 1) {
                s++;
                max = Math.max(max, s);
            } else
                s = 0;
        return max;
    }
}
