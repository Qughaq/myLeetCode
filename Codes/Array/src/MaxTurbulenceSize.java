public class MaxTurbulenceSize {
    public static void main(String[] args) {
        int[] nums = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(maxTurbulenceSize(nums));
    }

    public static int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 2) return len;
        int left = 0, right = 1, res = 1;
        boolean pre = false;
        while (right < len) {
            // true为上升，false为下降
            boolean current = arr[right - 1] < arr[right];
            if (right == 1 || current == pre) {
                left = right - 1;
            }
            if (arr[right - 1] == arr[right]) {
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
            pre = current;
        }
        return res;
    }
}
