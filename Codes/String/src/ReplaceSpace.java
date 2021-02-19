public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                result.append("%20");
            } else
                result.append(ch);
        }
        return result.toString();
    }

    public String replaceSpace2(String s) {
        return s.replace(" ", "%20");
    }
}
