import java.util.stream.IntStream;

public class IsToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix1(int[][] matrix) {
        return IntStream.range(1, matrix.length).noneMatch(i -> IntStream.range(1, matrix[0].length).anyMatch(j -> matrix[i][j] != matrix[i - 1][j - 1]));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }
}
