import java.util.Arrays;

public class OddCells1252 {
    public static void main(String[] args) {
        int n = 2, m = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells(n, m, indices));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] matrix = new int[n][m];
        for (int[] indice : indices) {
            int row = indice[0];
            int column = indice[1];
            for (int i = 0; i < m; i++)
                matrix[row][i]++;
            for (int j = 0; j < n; j++)
                matrix[j][column]++;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] % 2 != 0)
                    count++;
        return count;
    }
}
