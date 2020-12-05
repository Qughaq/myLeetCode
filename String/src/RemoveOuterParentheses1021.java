public class RemoveOuterParentheses1021 {
    public static void main(String[] args) {
        String S = "(()())(())";
        System.out.println(removeOuterParentheses(S));
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int opened = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(' && opened++ > 0) result.append(ch);
            if (ch == ')' && opened-- > 1) result.append(ch);
        }
        return result.toString();
    }
}
