public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int distance = 0;
        if (x % 2 != y % 2)
            distance++;
        while (x != 0 && y != 0) {
            if (x % 2 != y % 2)
                distance++;
            x = x / 2;
            y = y / 2;
        }
        return distance;
    }
}
