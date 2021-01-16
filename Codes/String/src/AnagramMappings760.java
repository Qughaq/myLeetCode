import java.util.Arrays;
import java.util.HashMap;

public class AnagramMappings760 {
    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50},
                B = {50, 12, 32, 46, 28};
        System.out.println(Arrays.toString(anagramMappings(A, B)));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < B.length; i++)
            if (!hashMap.containsKey(B[i]))
                hashMap.put(B[i], i);
        for (int i = 0; i < A.length; i++)
            result[i] = hashMap.get(A[i]);
        return result;
    }
}
