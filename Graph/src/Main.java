public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        MakeConnected makeConnected = new MakeConnected();
        System.out.println(makeConnected.makeConnected(n, connections));
    }
}
