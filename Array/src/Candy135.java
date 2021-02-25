import java.util.Arrays;

public class Candy135 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++)
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        int count = left[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

    public static int candy1(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++)
            if (i > 0 && ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        int right = 0, count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1])
                right++;
            else
                right = 1;
            count += Math.max(left[i], right);
        }
        return count;
    }
}
