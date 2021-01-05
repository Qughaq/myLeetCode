import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int len = nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++)
            temp[i] = nums[len - k + i];
        for (int i = len - k - 1; i >= 0; i--)
            nums[i + k] = nums[i];
        for (int i = 0; i < k; i++)
            nums[i] = temp[i];
    }
}
