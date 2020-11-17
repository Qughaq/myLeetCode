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

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        // 将数组中的元素所对应的index位置的数取反，最后没有取反的元素的index即为消失的数
        for (int i = 0; i < nums.length; i++)
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                result.add(i + 1);
        return result;
    }

    public static int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int n : nums) {
            if (n == firstMax || n == secondMax || n == thirdMax)
                continue;
            if (n > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            } else if (n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (n > thirdMax)
                thirdMax = n;
        }
        return (int) (thirdMax == Long.MIN_VALUE ? firstMax : thirdMax);
    }

    public static int heightChecker(int[] heights) {
        int count = 0;
        int[] sorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted);
        for (int i = 0; i < heights.length; i++)
            if (sorted[i] != heights[i])
                count++;
        return count;
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int j = 0; j < nums.length; j++)
            if (nums[j] != nums[i])
                nums[++i] = nums[j];
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++)
            if (nums[j] != val)
                nums[i++] = nums[j];
        return i;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0)
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                i++;
                if (arr.length - 1 - i >= 0)
                    System.arraycopy(arr, i, arr, i + 1, arr.length - 1 - i);
                arr[i] = 0;
            }
        }
    }


    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++)
            A[i] = A[i] * A[i];
        Arrays.sort(A);
        return A;
    }

    public static int findNumbers(int[] nums) {
        int numbers = 0;
        int numberOfDigits = 0;
        for (int num : nums) {
            int s = num;
            while (s > 0) {
                numberOfDigits++;
                s = s / 10;
            }
            if (numberOfDigits % 2 == 0)
                numbers++;
        }
        return numbers;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        int s = 0;
        for (int num : nums)
            if (num == 1) {
                s++;
                max = Math.max(max, s);
            } else
                s = 0;
        return max;
    }
}
