import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>();
        for (Character ch : "aeiouAEIOU".toCharArray())
            vowelSet.add(ch);
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (vowelSet.contains(chars[left]) && vowelSet.contains(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else if (!vowelSet.contains(chars[left]))
                left++;
            else if (!vowelSet.contains(chars[right]))
                right--;
        }
        return String.valueOf(chars);
    }

    public static String reverseVowels1(String s) {
        Set<Character> vowelSet = new HashSet<>();
        for (Character ch : "aeiouAEIOU".toCharArray())
            vowelSet.add(ch);
        StringBuilder result = new StringBuilder();
        Stack<Character> vowelStack = new Stack<>();
        for (char ch : s.toCharArray())
            if (vowelSet.contains(ch))
                vowelStack.add(ch);
        for (char ch : s.toCharArray()) {
            if (!vowelSet.contains(ch))
                result.append(ch);
            else
                result.append(vowelStack.pop());
        }
        return result.toString();
    }
}
