import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildArray1441 {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        int len = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add("Push");
            if (i == target[len]) len++;
            else result.add("Pop");
            if (len == target.length) return result;
        }
        return null;
    }
}
