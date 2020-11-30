import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySolutions {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= target)
                return i;
        return nums.length;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {

        return null;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int maxIndex = -1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int num : nums)
            if (num != max && max < 2 * num)
                return -1;
        return maxIndex;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int rev = 0;
        int lastDigit;
        while (x != 0 && x > rev) {
            lastDigit = x % 10;
            rev = rev * 10 + lastDigit;
            x /= 10;
        }
        return rev == x || rev / 10 == x;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair))
                return new int[]{map.get(pair), i};
            map.put(nums[i], i);
        }
        return null;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right)
            return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;


        return 0;
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == sum)
                return i;
            leftSum += nums[i];
        }
        return -1;
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

    public int longestMountain(int[] arr) {
        int maxLen = 1;
        int i = 0;
        while (i < arr.length) {
            int increasing = 0, decreasing = 0;
            while (i < arr.length && arr[i - 1] < arr[i]) {
                i++;
                increasing++;
            }
            while (i < arr.length && arr[i - 1] > arr[i]) {
                i++;
                decreasing++;
            }
            if (increasing > 0 && decreasing > 0)
                maxLen = Math.max(maxLen, increasing + decreasing + 1);
            while (i < arr.length && arr[i - 1] == arr[i]) i++;
        }
        return maxLen;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length >= 3) {
            int left = 0;
            int right = arr.length - 1;
            // 左侧爬山
            while (left < arr.length - 1 && arr[left] < arr[left + 1])
                left++;
            // 右侧爬山
            while (right > 1 && arr[right] < arr[right - 1])
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
