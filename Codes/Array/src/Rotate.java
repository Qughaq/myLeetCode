import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int len = nums.length;
        int[] temp = new int[k];
        if (k >= 0) System.arraycopy(nums, len - k, temp, 0, k);
        if (len - k >= 0) System.arraycopy(nums, 0, nums, k, len - k);
        if (k >= 0) System.arraycopy(temp, 0, nums, 0, k);
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
