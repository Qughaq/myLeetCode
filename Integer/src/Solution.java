public class Solution {
    public static void main(String[] args) {
//        int x = 123;
//        System.out.println(reverse(x));

//        int num = 8;
//        System.out.println(numberOfSteps(num));
    }




    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) num /= 2;
            else num--;
            count++;
        }
        return count;
    }

    public static int reverse(int x) {
        int result;
        StringBuilder str = new StringBuilder(x + "").reverse();
        if (x < 0)
            str.deleteCharAt(str.length() - 1);
        long num = Long.parseLong(str.toString());
        if (num > Integer.MAX_VALUE)
            result = 0;
        else
            result = (int) num;
        return x < 0 ? -result : result;
    }
}
