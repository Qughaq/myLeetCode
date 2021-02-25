import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public int[] fraction(int[] cont) {
        int n = cont[cont.length - 1];
        int m = 1;
        for (int i = cont.length - 2; i >= 0; i--) {
            int temp = n;
            n = cont[i] * n + m;
            m = temp;
        }
        return new int[]{n, m};
    }

    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++)
            lastIndex[charArray[i] - 'a'] = i;
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a'])
                continue;
            while (!stack.isEmpty()
                    && stack.peekLast() > charArray[i]
                    && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack)
            sb.append(ch);
        return sb.toString();
    }
}
