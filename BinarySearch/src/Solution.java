import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 8, 8, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    // 二分查找， 时间复杂度位log(n)
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return new int[]{-1, -1};
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1)
            return new int[]{-1, -1};
        int lsatPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lsatPosition};
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] < target)
                // 下一轮搜索区间是[mid + 1, right]
                left = mid + 1;
            else if (nums[mid] == target)
                // 下一轮搜索区间是[mid, right]
                left = mid;
            else
                // nums[mid] > target
                // 下一轮搜索区间是[left, mid - 1]
                right = mid - 1;
        }
        return left;
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                // 下一轮搜索区间是[mid + 1, right]
                left = mid + 1;
            else if (nums[mid] == target)
                // 下一轮搜索区间是[left, mid]
                right = mid;
            else
                // nums[mid] > target
                // 下一轮搜索区间是[left, mid - 1]
                right = mid - 1;
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}
