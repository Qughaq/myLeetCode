public class MyPow {

    public static void main(String[] args) {
        double x = 2;


        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = getPow(x, Math.abs((long) n));
        return n > 0 ? result : 1 / result;
    }

    private static double getPow(double x, long n) {
        if (n == 1)
            return x;
        else {
            double half = getPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }
    }
}
