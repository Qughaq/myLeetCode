public class FindMaxAverage2 {
    public static void main(String[] args) {
        int[] nums = {0, 4, 0, 3, 2};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        for (int s = 0; s < nums.length - k + 1; s++) {
            long sum = 0;
            for (int i = s; i < nums.length; i++) {
                sum += nums[i];
                if (i - s + 1 >= k)
                    res = Math.max(res, sum * 1.0 / (i - s + 1));
            }
        }
        return res;
    }
}
