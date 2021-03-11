import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                result[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return result;
    }
}
