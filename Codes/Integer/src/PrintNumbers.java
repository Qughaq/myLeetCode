import java.util.Arrays;
import java.util.stream.IntStream;

public class PrintNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }

    public static int[] printNumbers(int n) {
        return IntStream.range(0, (int) Math.pow(10, n) - 1).map(i -> i + 1).toArray();
    }

    public static int[] printNumbers1(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
