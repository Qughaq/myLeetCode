import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int x = 123;
//        System.out.println(reverse(x));

        int[] num = {1, 3, 2};
        System.out.println(almostIncreasingSequence(num));
    }

    public static boolean almostIncreasingSequence(int[] sequence) {
        int remove = 0;
        int i = 0;
        while (i < sequence.length - 1)
            if (sequence[i] < sequence[i + 1]) i++;
            else {
                remove++;
                if (i < sequence.length - 2
                        && sequence[i + 1] <= sequence[i - 1]
                        && sequence[i + 2] <= sequence[i])
                    remove++;
                else i++;
                if (remove > 1) return false;
            }
        return true;
    }

    public static int makeArrayConsecutive2(int[] statues) {
        int count = 0;
        Arrays.sort(statues);
        for (int i = 0; i < statues.length - 1; i++)
            count += statues[i + 1] - statues[i] - 1;
        return count;
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
