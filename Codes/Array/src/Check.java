import java.util.stream.IntStream;

public class Check {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        return IntStream.range(0, nums.length).filter(i -> nums[i] > nums[(i + 1) % nums.length]).count() <= 1;
    }

    public static boolean check1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length])
                count++;
        }
        return count <= 1;
    }

    public static boolean check2(int[] nums) {
        int len = nums.length;
        //是否经过轮转,如果第一个数大于等于最后一个数，那肯定是轮转过的
        boolean isRotated = nums[0] >= nums[len - 1];
        for (int i = 1; i < len; i++)
            if (nums[i] < nums[i - 1])
                if (isRotated)
                    isRotated = false;
                else
                    return false;
        return true;
    }
}
