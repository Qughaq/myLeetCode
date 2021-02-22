import java.util.Arrays;

public class TrimMean {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        System.out.println(trimMean(arr));
    }

    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int a : A) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        return Math.max(0, max - min - 2 * K);
    }

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int remove = (int) (len * 0.05);
        int sum = 0;
        for (int i = remove; i < len - remove; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / (len - 2 * remove);
    }
}
