import java.util.Stack;
import java.util.TreeMap;

public class Find132pattern {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 4};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        int len = nums.length;
        int[] minLeft = new int[len];
        // 第一个位置的最小数肯定就是它自己了
        minLeft[0] = nums[0];
        // 将前一个位置的最小数和当前位置的数比较，找到当前位置的最小数
        for (int i = 1; i < len; ++i) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        // 从后往前遍历，stack 中的数字表示的是从位置 i 到 len 中，大于 minLeft[i] 且小于 nums[i] 的数
        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] > minLeft[i]) {
                // 如果栈中的数字比 minLeft[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                while (!stack.isEmpty() && stack.peek() <= minLeft[i])
                    stack.pop();
                // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                if (!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                // 不管怎样都要push进来当前的数，因为当前的数满足了大于 minLeft[i]
                stack.push(nums[i]);
            }
        }
        // 到最后都没找到，肯定只能返回false了
        return false;
    }

    public static boolean find132pattern1(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        for (int k = 2; k < len; k++) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }
        for (int j = 1; j < len - 1; j++) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }
        return false;
    }
}
