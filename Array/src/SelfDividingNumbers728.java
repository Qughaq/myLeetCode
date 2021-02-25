import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public static void main(String[] args) {
        int left = 9;
        int right = 10000;
        System.out.println(selfDividingNumbers(left, right));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int number = left; number <= right; number++) {
            char[] chars = String.valueOf(number).toCharArray();
            int count = 0;
            for (char ch : chars) {
                int temp = Integer.parseInt(String.valueOf(ch));
                if (temp != 0 && number % temp == 0)
                    count++;
            }
            if (count == chars.length)
                result.add(number);
        }
        return result;
    }
}
