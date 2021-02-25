import javax.xml.soap.Node;
import java.util.LinkedList;

public class ReverseWords151 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }


    // 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        int len = split.length;
        for (int i = 0; i < len; i++) {
            String word = split[i];
            StringBuilder sb2 = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--)
                sb2.append(word.charAt(j));
            sb.append(sb2.toString());
            if (i < len - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    // 反转单词
    public static String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        sb.append(split[split.length - 1]);
        for (int i = split.length - 2; i >= 0; i--)
            if (!split[i].equals(""))
                sb.append(" ").append(split[i]);
        return sb.toString();
    }
}
