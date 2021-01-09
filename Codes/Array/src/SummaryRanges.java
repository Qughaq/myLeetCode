import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int start = i++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1)
                i++;
            int end = i - 1;
            StringBuilder sb = new StringBuilder(Integer.toString(nums[start]));
            if (start < end)
                sb.append("->").append(nums[end]);
            result.add(sb.toString());
        }
        return result;
    }
}
