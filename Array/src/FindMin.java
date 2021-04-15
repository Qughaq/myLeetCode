public class FindMin {
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 1, 1, 1, 2, 3, 4, 5, 6};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right--;
            }
        }
        return nums[left];
    }

    public static int findMin1(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                return nums[i];
        return nums[0];
    }
}
