public class RemoveVowels1119 {
    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(removeVowels(s));
    }

    public static String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : s.toCharArray())
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                sb.append(ch);
        return sb.toString();
    }

    public static String removeVowels1(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}
