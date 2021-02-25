import java.util.Arrays;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(A)));
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int rowLen = A[0].length;
        for (int[] row : A)
            for (int i = 0; i < (rowLen + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[rowLen - 1 - i] ^ 1;
                row[rowLen - 1 - i] = tmp;
            }
        return A;
    }

    public int[][] flipAndInvertImage1(int[][] A) {
        for (int[] row : A) {
            for (int j = 0; j < row.length / 2; j++) {
                int temp = row[j];
                row[j] = row[row.length - j - 1];
                row[row.length - j - 1] = temp;
            }
        }
        for (int[] row : A) {
            for (int j = 0; j < row.length; j++) {
                row[j] = row[j] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
