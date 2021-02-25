import java.util.Collections;
import java.util.HashMap;

public class CountGoodRectangles {
    public static void main(String[] args) {
        int[][] rectangles = {{5, 8}, {3, 9}, {3, 12}};
        System.out.println(countGoodRectangles(rectangles));
    }

    public static int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, tempLen, count = 1;
        for (int[] rectangle : rectangles) {
            tempLen = Math.min(rectangle[0], rectangle[1]);
            if (tempLen > maxLen) {
                maxLen = tempLen;
                count = 1;
            } else if (tempLen == maxLen) {
                count++;
            }
        }
        return count;
    }
}
