import java.util.HashSet;
import java.util.Set;

public class NumEquivDominoPairs {
    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Set<Integer> seen = new HashSet<>();
        for (int[] dominoe : dominoes) {
            int key = dominoe[0] * 10 + dominoe[1];
            if (dominoe[0] > dominoe[1]) {
                key = dominoe[1] * 10 + dominoe[0];
            }
            if (seen.contains(key)) count++;
            else
                seen.add(key);
        }
        return count;
    }

    public static int numEquivDominoPairs2(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val;
            if (domino[0] < domino[1])
                val = domino[0] * 10 + domino[1];
            else
                val = domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
