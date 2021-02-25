import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ValidWordAbbr {
    HashMap<String, Set<String>> hashMap = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = toAbbr(word);
            if (hashMap.containsKey(abbr))
                hashMap.get(abbr).add(word);
            else {
                Set<String> set = new HashSet<>();
                set.add(word);
                hashMap.put(abbr, set);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        if (hashMap.containsKey(abbr)) {
            Set<String> set = hashMap.get(abbr);
            if (set.contains(word))
                return set.size() == 1;
            else
                return false;
        } else
            return true;
    }

    public static String toAbbr(String word) {
        int len = word.length();
        return len <= 2 ? word : word.substring(0, 1) + (len - 2) + word.substring(len - 1);
    }
}