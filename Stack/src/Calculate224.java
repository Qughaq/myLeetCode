import java.util.Deque;
import java.util.LinkedList;

public class Calculate224 {
    public static void main(String[] args) {
        String s = "(1-(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1, result = 0, len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                if (!ops.isEmpty()) {
                    sign = ops.peek();
                }
                i++;
            } else if (s.charAt(i) == '-') {
                if (!ops.isEmpty()) {
                    sign = -ops.peek();
                }
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }
}
