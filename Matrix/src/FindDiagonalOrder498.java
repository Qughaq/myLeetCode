import java.util.Arrays;

public class FindDiagonalOrder498 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println((Arrays.toString(findDiagonalOrder(matrix))));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[]{};
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] arr = new int[M * N][3];
        int[] result = new int[M * N];
        int index = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                // j+j代表对角线，j为偶增序，j为奇减序
                arr[index++] = new int[]{i + j, j, matrix[i][j]};
        Arrays.sort(arr, (a, b) -> {
            // 按照i+j排序， i+j代表对角线数
            if (a[0] != b[0])
                return a[0] - b[0];
            // 如果对角线是奇数，需要按照j从大到小排序
            if (a[0] % 2 == 1)
                return b[1] - a[1];
            return a[1] - b[1];
        });
        for (int i = 0; i < M * N; i++)
            result[i] = arr[i][2];
        return result;
    }
}
