

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
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
