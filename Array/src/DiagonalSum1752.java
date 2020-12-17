import java.util.Arrays;

public class DiagonalSum1752 {
    public static void main(String[] args) {
//        int[][] mat = {{5}};
//        System.out.println(diagonalSum(mat));int
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++)
            sum += mat[i][i] + mat[len - i - 1][i];
        if (len % 2 == 1)
            sum -= mat[len / 2][len / 2];
        return sum;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i])
                result++;
        }
        return result;
    }

    public static int maxProduct(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (i != j)
                    result = Math.max(result, (nums[i] - 1) * (nums[j] - 1));
        return result;
    }

    public static int maxProduct2(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        return (sorted[nums.length] - 1) * (sorted[nums.length] - 1);
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];

        return null;
    }
}
