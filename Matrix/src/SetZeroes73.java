import java.util.Arrays;
import java.util.HashSet;

public class SetZeroes73 {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public static void setZeroes(int[][] matrix) {
        boolean isCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                isCol = true;
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        }
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (matrix[0][0] == 0)
            Arrays.fill(matrix[0], 0);

        if (isCol)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }

    public static void setZeroes1(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (rowSet.contains(i) || columnSet.contains(j))
                    matrix[i][j] = 0;
    }
}
