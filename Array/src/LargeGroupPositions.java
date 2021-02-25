import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(largeGroupPositions(s));
    }

    // 单指针
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int count = 0;//相同字符串的长度
            //统计相同字符串的长度
            while (start + count < s.length() && s.charAt(start) == s.charAt(start + count))
                count++;
            //如果长度大于等于3，就把他加入到res中
            if (count >= 3)
                res.add(Arrays.asList(start, start + count - 1));
            //更新下一个字符串的左边边界
            start = start + count;
        }
        return res;
    }

    // 双指针
    public static List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            while (end > 0 && end < s.length() && s.charAt(end) == s.charAt(end - 1))
                end++;
            if (end - start >= 3)
                result.add(Arrays.asList(start, end - 1));
            start = end++;
        }
        return result;
    }
}
