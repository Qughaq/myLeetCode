import java.util.Arrays;
import java.util.stream.Stream;

public class StringSolution {
    public static void main(String[] args) {
//        String num = "1432219";
//        System.out.println(removeKdigits(num, 3));

//        String address = "1.1.1.1";
//        System.out.println(defangIPaddr(address));

//        String[] word1 = {"ab", "c"}, word2 = {"a", "bcg"};
//        System.out.println(arrayStringsAreEqual(word1, word2));
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }

    public static String toLowerCase(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) <= 90 && str.charAt(i) >= 65)
                res.append((char) (str.charAt(i) + 32));
            else
                res.append(str.charAt(i));
        return res.toString();
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (String word : word1)
            str1.append(word);
        for (String word : word2)
            str2.append(word);
        return str1.toString().equals(str2.toString());
    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        StringBuilder result = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int index = 0;
            for (int j = 1; j < result.length() && result.charAt(j) >= result.charAt(j - 1); j++)
                index = j;
            result.delete(index, index + 1);
            while (result.length() > 1 && result.charAt(0) == '0')
                result.delete(0, 1);
        }
        return result.toString();
    }
}
