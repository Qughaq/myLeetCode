import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solutions {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        moveZeroes(arr);
        System.out.println((findDuplicates(arr)));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0)
                nums[index] *= -1;
            else
                result.add(index + 1);
        }
        return result;
    }

    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static int[] sortArrayByParity(int[] A) {
        for (int slow = 0, fast = 0; fast < A.length; fast++) {
            if (A[fast] % 2 == 0) {
                A[fast] = (A[fast] + A[slow]) - (A[slow++] = A[fast]);
            }
        }
        return A;
    }

    private static void swap(int i, int i1) {
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

    public static int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = -1;
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length >= 3) {
            int left = 0;
            int right = arr.length - 1;
            // 左侧爬山
            while (left + 1 < arr.length && arr[left] < arr[left + 1])
                left++;
            // 右侧爬山
            while (right - 1 > 0 && arr[right] < arr[right - 1])
                right--;
            if (left == arr.length - 1) // 只有上破
                return false;
            else if (right == 0) // 只有下坡
                return false;
            return left == right;
        }
        return false;
    }

    public static boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashtable.containsValue(arr[i] * 2) || (arr[i] % 2 == 0 && hashtable.containsValue(arr[i] / 2))) {
                return true;
            }
            hashtable.put(i, arr[i]);
        }
        return false;
    }
}
