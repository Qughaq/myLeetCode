public class CountNegatives1351 {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] rows : grid)
            for (int j = 0; j < rows.length; j++)
                if (rows[j] < 0) {
                    count += rows.length - j;
                    break;
                }
        return count;
    }
}
