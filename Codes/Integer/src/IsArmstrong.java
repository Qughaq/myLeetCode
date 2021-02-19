public class IsArmstrong {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }

    public static boolean isArmstrong(int N) {
        int k = 0, sum = 0;
        int temp = N;
        while (temp != 0) {
            k++;
            temp /= 10;
        }
        temp = N;
        while (temp != 0) {
            sum += Math.pow(temp % 10, k);
            temp /= 10;
        }
        return N == sum;
    }
}
