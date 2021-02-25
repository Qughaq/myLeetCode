import java.util.Arrays;

public class Decode1720 {
    public static void main(String[] args) {

        int[] encoded = {1, 2, 3};
        int first = 1;
        System.out.println(Arrays.toString(decode(encoded, first)));
    }

    public static int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 1; i < decoded.length; i++) {
            decoded[i] = encoded[i - 1] ^ decoded[i - 1];
        }
        return decoded;
    }
}
