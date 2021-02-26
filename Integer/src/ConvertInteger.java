public class ConvertInteger {
    public static void main(String[] args) {
        int A = 1, B = 2;
        System.out.println(convertInteger(A, B));
    }

    public static int convertInteger(int A, int B) {
        int C = A ^ B;
        int count = 0;
        while (C != 0) {
            count++;
            C &= C - 1;
        }
        return count;
    }
}
