

public class NumIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(islandPerimeter(grid));
    }

    /**
     * You are given row x col grid representing a map
     * where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
     * /*Grid cells are connected horizontally/vertically (not diagonally).
     * The grid is completely surrounded by water,
     * and there is exactly one island (i.e., one or more connected land cells).
     * /*The island doesn't have "lakes",
     * meaning the water inside isn't connected to the water around the island.
     * One cell is a square with side length 1.
     * The grid is rectangular, width and height don't exceed 100.
     * Determine the perimeter of the island.
     */
    public static int islandPerimeter(int[][] grid) {
        int result = 0;
//        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    result++;
                    if (i > 0 && grid[i - 1][j] == 1) result++;
                    if (j > 0 && grid[i][j - 1] == 1) result++;
                }
        return result;
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') {
                    count++;
                    BFS(grid, i, j);
                }
        return count;
    }

    private static void BFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0
                || j >= grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        BFS(grid, i + 1, j);  //up
        BFS(grid, i - 1, j);  //down
        BFS(grid, i, j - 1);  //left
        BFS(grid, i, j + 1);  //right
    }
}
