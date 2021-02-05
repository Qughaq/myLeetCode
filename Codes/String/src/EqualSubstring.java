public class EqualSubstring {

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int cost = 3;
        System.out.println(equalSubstring(s, t, cost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < len; end++) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
