import java.util.Arrays;

public class ProductExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0, forward = 1; i < len; i++) {
            result[i] = forward;
            forward *= nums[i];
        }
        for (int i = len - 1, backward = 1; i >= 0; i--) {
            result[i] *= backward;
            backward *= nums[i];
        }
        return result;
    }

    // brute force 过不了时间限制
    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int productI = 1;
            for (int j = 0; j < nums.length; j++)
                if (i != j)
                    productI *= nums[j];
            result[i] = productI;
        }
        return result;
    }
}
