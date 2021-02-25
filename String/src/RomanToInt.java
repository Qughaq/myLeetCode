public class RomanToInt {
    public static void main(String[] args) {

    }

    public static int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += getValue(s.charAt(i));
        }
        return result;
    }

    public static int getValue(char ch) {
        if (ch == 'I') {
            return 1;
        } else if (ch == 'V') {
            return 5;
        } else if (ch == 'X') {
            return 10;
        } else if (ch == 'L') {
            return 50;
        } else if (ch == 'C') {
            return 100;
        } else if (ch == 'D') {
            return 500;
        } else if (ch == 'M') {
            return 1000;
        } else if (ch == 'a') {
            return 4;
        } else if (ch == 'b') {
            return 9;
        } else if (ch == 'c') {
            return 40;
        } else if (ch == 'd') {
            return 90;
        } else if (ch == 'e') {
            return 400;
        } else if (ch == 'f') {
            return 900;
        }
        return 0;
    }
}
