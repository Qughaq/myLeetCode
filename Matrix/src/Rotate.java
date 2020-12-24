import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int i = 0;
        while (i < len / 2) {
            int[] A = {i, i};
            int[] B = {i, i + len - 2 * i - 1};
            int[] C = {len - i - 1, i + len - 2 * i - 1};
            int[] D = {len - i - 1, i};
            for (int j = 0; j < len - 2 * i - 1; j++) {
                matrix[A[0]][A[1] + j] = matrix[D[0] - j][D[1]];
                matrix[B[0] + j][B[1]] = matrix[A[0]][A[1] + j];
                matrix[C[0]][C[1] - j] = matrix[B[0] + j][B[1]];
                matrix[D[0] - j][D[1]] = matrix[C[0]][C[1] - j];
            }
            i++;
        }
    }
}
