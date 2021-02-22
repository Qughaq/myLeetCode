public class MergeAlternately {
    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < len1 || index < len2) {
            if (index < len1) sb.append(word1.charAt(index));
            if (index < len2) sb.append(word2.charAt(index));
            index++;
        }
        return sb.toString();
    }
}
