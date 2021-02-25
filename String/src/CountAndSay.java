import java.util.Objects;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        if (n >= 2) {
            String prev = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Objects.requireNonNull(prev).length(); i++) {
                int count = 1;
                while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count).append(prev.charAt(i));
            }
            return sb.toString();
        }
        return null;
    }
}
