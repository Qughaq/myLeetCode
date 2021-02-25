public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a 111anal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (Character.isLetterOrDigit(s.charAt(i)))
                sb.append(Character.toLowerCase(s.charAt(i)));
        for (int i = 0, j = sb.length() - 1; i < j; i++, j--)
            if (sb.charAt(i) != sb.charAt(j)) return false;
        return true;
    }
}
