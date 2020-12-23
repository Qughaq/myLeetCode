import java.util.Arrays;

public class SumZero1304 {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(Arrays.toString(sumZero(num)));
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; ++i)
            result[i] = i * 2 - n + 1;
        return result;
    }
}
