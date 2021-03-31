import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsets(nums));
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> subSet : result) {
                List<Integer> newSubSet = new ArrayList<>(subSet);
                newSubSet.add(num);
                newSubSets.add(newSubSet);
            }
            result.addAll(newSubSets);
        }
        return result;
    }
}
