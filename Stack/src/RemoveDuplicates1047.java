import java.util.Stack;

public class RemoveDuplicates1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    // 用stack
    public static String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() == arr[i])
                stack.pop();
            else
                stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    // brut force
    public static String removeDuplicates1(String S) {
        for (int i = 0; i < S.length() - 1; i++)
            if (S.charAt(i) == S.charAt(i + 1)) {
                S = S.substring(0, i) + S.substring(i + 2);
                i = -1;
            }
        return S;
    }
}
