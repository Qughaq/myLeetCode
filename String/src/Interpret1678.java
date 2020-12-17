public class Interpret1678 {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        System.out.println(interpret1(command));
    }

    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G')
                result.append('G');
            if (command.charAt(i) == '(') {
                if (i < command.length() - 1 && command.charAt(i + 1) == ')')
                    result.append('o');
                if (i < command.length() - 3 && command.charAt(i + 1) == 'a')
                    result.append("al");
            }
        }
        return result.toString();
    }

    public static String interpret1(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
