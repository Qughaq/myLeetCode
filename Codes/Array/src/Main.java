public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        int[][] languages = {{1}, {2}, {1, 2}};
        int[][] friendships = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(solution.minimumTeachings(n, languages, friendships));
    }
}
