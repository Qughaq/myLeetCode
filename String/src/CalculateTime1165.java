import java.util.HashMap;

public class CalculateTime1165 {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        System.out.println(calculateTime(keyboard, word));
    }

    public static int calculateTime(String keyboard, String word) {
        int count = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            hashMap.put(keyboard.charAt(i), i);
        }
        count += hashMap.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            count += Math.abs(hashMap.get(word.charAt(i)) - hashMap.get(word.charAt(i - 1)));
        }
        return count;
    }
}
