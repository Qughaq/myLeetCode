import java.util.TreeSet;

public class MaxSumSubmatrix363 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix, k));
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int c = 0; c < n; c++) {
                    sum[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        result = Math.max(result, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return result;
    }
}
