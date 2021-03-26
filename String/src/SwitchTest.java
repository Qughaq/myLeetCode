public class SwitchTest {
    public static void main(String[] args) {
        // 当switch括号内的变量为String类型的外部
        // 参数时，且看输出什么？
        String param = null;
        if ("param".equals(param)) {
            System.out.println("print param");
        } else if ("String".equals(param)) {
            System.out.println("print String");
        } else if ("null".equals(param)) {
            System.out.println("print null");
        } else {
            System.out.println("default");
        }
    }
}
