import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> temp = new ArrayList<>(i);


            int x = 10;

        }
        return null;
    }
}
