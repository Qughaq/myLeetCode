import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        int first = 0, result = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (stack.empty()) {
                result = Math.max(result, i - first);
                first = i;
            }
            char ch = charArray[i];
            if (ch == ')' && !stack.empty()) {
                stack.pop();
            }
            if (ch == '(') {
                stack.push(ch);
            }
        }

        return 0;
    }
}
