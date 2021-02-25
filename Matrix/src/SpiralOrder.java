import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n) + 1) / 2;
        //从外部向内部遍历，逐层打印数据
        int index = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < n - i; j++)
                result[index++] = matrix[i][j];
            for (int j = i + 1; j < m - i; j++)
                result[index++] = matrix[j][(n - 1) - i];
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--)
                result[index++] = matrix[(m - 1) - i][j];
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--)
                result[index++] = matrix[j][i];
        }
        return result;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 向右
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            // 向下
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                // 向左
                for (int column = right - 1; column > left; column--) {
                    result.add(matrix[bottom][column]);
                }
                // 向上
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }
}
