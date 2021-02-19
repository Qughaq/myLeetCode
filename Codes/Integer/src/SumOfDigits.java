import java.util.Arrays;

public class SumOfDigits {
    public static void main(String[] args) {
        int[] A = {99, 77, 33, 66, 55};
        System.out.println(sumOfDigits(A));
    }

    public static int sumOfDigits(int[] A) {
        int min = A[0];
        for (int a : A) {
            min = Math.min(a, min);
        }
        int S = 0;
        while (min != 0) {
            S += min % 10;
            min /= 10;
        }
        return S % 2 == 1 ? 0 : 1;
    }
}
