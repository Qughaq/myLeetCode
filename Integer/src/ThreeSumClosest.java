import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int tempSum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - tempSum) < Math.abs(target - threeSum))
                    threeSum = tempSum;
                if (tempSum > target) end--;
                else if (tempSum < target) start++;
                else return threeSum;
            }
        }
        return threeSum;
    }

    public static int threeSumClosest1(int[] nums, int target) {
        int len = nums.length;
        int threeSum = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - threeSum);
        int result = threeSum;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j != i && j < len; j++) {
                for (int x = 0; x != i && x != j && x < len; x++) {
                    int tempSum = nums[i] + nums[j] + nums[x];
                    int tempDiff = Math.abs(target - tempSum);
                    if (tempDiff < diff) {
                        diff = tempDiff;
                        threeSum = tempSum;
                        result = threeSum;
                    }
                }
            }
        }
        return result;
    }
}
