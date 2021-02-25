public class MaxSatisfied {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5}, grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println(maxSatisfied(customers, grumpy, X));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < len; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
