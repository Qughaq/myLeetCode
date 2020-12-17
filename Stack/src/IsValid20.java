import java.util.Stack;

public class IsValid20 {
    public static void main(String[] args) {
        String s = "(((((((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
                len++;
            } else if (!stack.empty()) {
                if (stack.peek().equals('(') && chars[i] == ')'
                        || stack.peek().equals('[') && chars[i] == ']'
                        || stack.peek().equals('{') && chars[i] == '}') {
                    stack.pop();
                    len--;
                }
            } else len++;
        }
        return len == 0;
    }
}
