import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DiagonalSum1752 {
    public static void main(String[] args) {
//        int[][] mat = {{5}};
//        System.out.println(diagonalSum(mat));int

        int[][] intervals = {{4, 5}, {1, 4}};
        System.out.println(Arrays.toString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
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
