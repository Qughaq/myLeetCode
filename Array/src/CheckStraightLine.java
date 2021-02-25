public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0)
                return false;
        }
        return true;
    }

    // 不能用斜率判断，精确度不准确
    public static boolean checkStraightLine2(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        double k = (coordinates[1][1] - coordinates[0][1]) * 1.0 / (coordinates[1][0] - coordinates[0][0]);
        double b = (coordinates[0][1] - coordinates[0][0]) * k;
        for (int i = 3; i < coordinates.length; i++) {
            double k2 = (coordinates[i][1] - coordinates[0][1]) * 1.0 / (coordinates[i][0] - coordinates[0][0]);
            double b2 = (coordinates[0][1] - coordinates[0][0]) * k;
            if (k != k2 || b != b2) return false;
        }
        return true;
    }
}
