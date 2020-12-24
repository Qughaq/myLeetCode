import java.util.ArrayList;
import java.util.HashSet;

public class StringSolution {
    public static void main(String[] args) {
//        String num = "1432219";
//        System.out.println(removeKdigits(num, 3));

//        String address = "1.1.1.1";
//        System.out.println(defangIPaddr(address));

//        String[] word1 = {"ab", "c"}, word2 = {"a", "bcg"};
//        System.out.println(arrayStringsAreEqual(word1, word2));
//        String str = "Hello";
//        System.out.println(toLowerCase(str));

//        String s = "codeleet";
//        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
//        System.out.println(restoreString(s, indices));

//        int n = 234;
//        System.out.println(subtractProductAndSum(n));

//        String s = "RLRRLLRLRL";
//        System.out.println(balancedStringSplit(s));

//        String s = "1+(2*3)/(2-1)";
//        System.out.println(maxDepth(s));

//        String A = "ab", B = "ba";
//        System.out.println(buddyStrings(A, B));

        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(n, connections));
    }

    public static int minReorder(int n, int[][] connections) {
        boolean[] reach = new boolean[n];
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] conn = connections[i];
            if (conn[0] == 0 || reach[conn[0]]) {
                res++;
                reach[conn[1]] = true;
            }
            reach[conn[0]] = true;
        }
        return res;
    }

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        HashSet<Character> hashSet = new HashSet<>();
        for (char a : A.toCharArray()) {
            hashSet.add(a);
        }
        if (A.equals(B) && hashSet.size() < A.length())
            return true;
        ArrayList<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); i++)
            if (A.charAt(i) != B.charAt(i))
                diff.add(i);
        return diff.size() == 2 &&
                A.charAt(diff.get(0)) == B.charAt(diff.get(1)) &&
                A.charAt(diff.get(1)) == B.charAt(diff.get(0));
    }

    public static boolean buddyStrings2(String A, String B) {
        for (int i = 0; i < A.length(); i++)
            for (int j = i + 1; j < A.length(); j++) {
                StringBuilder sb = new StringBuilder(A);
                char ch1 = A.charAt(i);
                char ch2 = A.charAt(j);
                sb.replace(i, i + 1, String.valueOf(ch2));
                sb.replace(j, j + 1, String.valueOf(ch1));
                if (sb.toString().equals(B))
                    return true;
            }
        return false;
    }

    public static int maxDepth(String s) {
        int max = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            max = Math.max(count, max);
            if (c == ')') count--;
        }
        return max;
    }

    public static int balancedStringSplit(String s) {
        int balancer = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') balancer++;
            if (c == 'R') balancer--;
            if (balancer == 0) count++;
        }
        return count;
    }

    public static int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n != 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }

    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            chars[indices[i]] = s.charAt(i);
        return new String(chars);
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
