import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge56 {
    public static void main(String[] args) {
        int[][] intervals = null;
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int[][] res = new int[intervals.length][2];
        int len = -1;
        for (int[] interval : intervals)
            if (len == -1 || interval[0] > res[len][1])
                res[++len] = interval;
            else
                res[len][1] = Math.max(res[len][1], interval[1]);
        return Arrays.copyOf(res, len + 1);
    }

    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        int len = 0;
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < left)
                result.add(new int[]{left, right});
            else
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
        }
        return result.toArray(new int[result.size()][]);
    }
}
