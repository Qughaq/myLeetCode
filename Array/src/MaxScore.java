import java.util.Arrays;

public class MaxScore {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int windowSize = len - k;
        int sum = Arrays.stream(cardPoints, 0, windowSize).sum();
        int minSum = sum;
        int start = 0, end = start + windowSize;
        while (start < len - windowSize) {
            sum = sum - cardPoints[start] + cardPoints[end];
            minSum = Math.min(minSum, sum);
            start++;
            end++;
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
