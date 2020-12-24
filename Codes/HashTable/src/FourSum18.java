import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Hashtable<Integer, List<Integer>> mapAB = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++)
                if (i != j) {
                    List<Integer> sumAB = new ArrayList<>();
                    sumAB.add(i);
                    sumAB.add(j);
                    mapAB.put(nums[i] + nums[j], sumAB);
                }
        }

        return null;
    }
}
