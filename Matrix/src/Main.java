public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(2, 1, 4, 3);
        System.out.println(param_1);
        int param_2 = obj.sumRegion(1, 1, 2, 2);
        System.out.println(param_2);
        int param_3 = obj.sumRegion(1, 2, 2, 4);
        System.out.println(param_3);

    }
}
