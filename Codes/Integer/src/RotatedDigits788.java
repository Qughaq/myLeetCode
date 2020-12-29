import java.util.Arrays;

public class RotatedDigits788 {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(rotatedDigits(N));
    }

    public static int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i))
                count++;
        }
        return count;
    }

    public boolean isGoodNumber(int N) {
        while (N!=0){
            int digit = N / 10;
            if (digit == )
            N =
        }
        return false;
    }
}
