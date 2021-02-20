import java.util.Arrays;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    arr[j + 1] = arr[j + 1] + arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
        }
        int[] result = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
