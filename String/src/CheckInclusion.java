public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];
        for (char ch : pattern)
            pFreq[ch - 'a']++;

        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        int winCount = 0;
        while (right < text.length) {
            if (pFreq[text[right] - 'a'] > 0) {
                winFreq[text[right] - 'a']++;
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                    winCount++;
                }
            }
            right++;
            while (pCount == winCount) {
                if (right - left == pattern.length) {
                    return true;
                }
                if (pFreq[text[left] - 'a'] > 0) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }
}
