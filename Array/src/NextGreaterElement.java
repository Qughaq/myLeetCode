import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return num;
        }
        return 0;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int num : nums2) {
            while (!stack.empty() && num > stack.peek())
                hashMap.put(stack.pop(), num);
            stack.push(num);
        }
        while (!stack.empty())
            hashMap.put(stack.pop(), -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            for (int j = i; j < len2; j++) {
                if (nums2[j] > nums2[i]) {
                    hashMap.put(nums2[i], nums2[j]);
                    break;
                } else hashMap.put(nums2[i], -1);
            }
        }
        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = hashMap.get(nums1[i]);
        }
        return result;
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            int j = 0;
            while (nums1[i] != nums2[j])
                j++;
            while (j < len2) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                } else result[i] = -1;
                j++;
            }
        }
        return result;
    }
}
