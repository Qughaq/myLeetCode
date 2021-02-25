public class IsPerfectSquare {
    public static void main(String[] args) {
        int num = 100;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }

    public static boolean isPerfectSquare2(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2, mid, squared;
        while (left <= right) {
            mid = left + (right - left) / 2;
            squared = mid * mid;
            if (squared == num)
                return true;
            else if (squared > num)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return false;
    }

    public static boolean isPerfectSquare1(int num) {
        int temp = num / 2 + 1;
        for (int i = 0; i <= temp; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
