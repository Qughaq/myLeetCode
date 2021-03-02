public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }

    public static int findNthDigit(int n) {
        n--;
        for (int digits = 1; digits < 11; digits++) {
            int first_num = (int) Math.pow(10, digits - 1);
            if (n < 9 * first_num * digits) {
                String target = String.valueOf(first_num + n / digits);
                char digit = target.charAt(n % digits);
                return digit - '0';
            }
            n -= 9 * first_num * digits;
        }
        return 0;
    }
}
