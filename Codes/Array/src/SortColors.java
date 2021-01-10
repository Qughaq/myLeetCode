import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int countRed = 0, countWhite = 0, countBlue = 0;
        for (int num : nums) {
            if (num == 0) countRed++;
            if (num == 1) countWhite++;
            if (num == 2) countBlue++;
        }
        int i = 0;
        while (countRed > 0) {
            nums[i++] = 0;
            countRed--;
        }
        while (countWhite > 0) {
            nums[i++] = 1;
            countWhite--;
        }
        while (countBlue > 0) {
            nums[i++] = 2;
            countBlue--;
        }
    }
}
