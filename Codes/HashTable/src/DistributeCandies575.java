import java.util.HashSet;

public class DistributeCandies575 {
    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3, 4};
        System.out.println(distributeCandies(candyType));
    }

    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>();
        for (int type : candyType)
            types.add(type);
        return Math.min(types.size(), candyType.length / 2);
    }
}
