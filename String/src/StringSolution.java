public class StringSolution {
    public static void main(String[] args) {
        String num = "1432219";
        System.out.println(removeKdigits(num, 3));
    }

    public static String removeKdigits(String num, int k) {
        if ( num.length() == k )
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
