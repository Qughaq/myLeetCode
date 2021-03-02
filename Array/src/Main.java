public class Main {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int n = 2;
//        int[][] languages = {{1}, {2}, {1, 2}};
//        int[][] friendships = {{1, 2}, {1, 3}, {2, 3}};
//        System.out.println(solution.minimumTeachings(n, languages, friendships));


        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 2);
        System.out.println(param_1);
        int param_2 = obj.sumRange(2, 5);
        System.out.println(param_2);
        int param_3 = obj.sumRange(0, 5);
        System.out.println(param_3);
    }
}
