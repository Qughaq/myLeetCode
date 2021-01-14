import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {
    public static void main(String[] args) {
        int[] A = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        System.out.println(prefixesDivBy5(A));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<>();
        int X = 0;
        for (int a : A) {
            X = (2 * X + a) / 10;
            answer.add(X % 5 == 0);
        }
        return answer;
    }
}
