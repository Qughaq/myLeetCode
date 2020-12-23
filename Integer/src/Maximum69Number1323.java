import java.util.ArrayList;
import java.util.List;

public class Maximum69Number1323 {
    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number1(num));
    }

    public static int maximum69Number1(int num) {
        return Integer.parseInt(("" + num).replaceFirst("6", "9"));
    }

    public static int maximum69Number(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
