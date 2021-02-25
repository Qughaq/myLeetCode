public class FreqAlphabets1309 {
    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; ) {
            if(i < n - 2 && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                ans.append((char) (num + 96));
                i = i + 3;
                continue;
            }
            ans.append((char) (97 + s.charAt(i) - '1'));
            i++;
        }
        return ans.toString();
    }
}
