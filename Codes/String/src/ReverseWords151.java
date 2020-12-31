public class ReverseWords151 {
    public static void main(String[] args) {
        String s = "       hello      world!       ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        sb.append(split[split.length - 1]);
        for (int i = split.length - 2; i >= 0; i--)
            if (!split[i].equals(""))
                sb.append(" ").append(split[i]);
        return sb.toString();
    }
}
