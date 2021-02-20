import java.util.Arrays;

public class CanBeEqual {
    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        int sum = 0, XOR = 0;
        for (int i = 0; i < target.length; i++) {
            XOR ^= arr[i];
            XOR ^= target[i];
            sum += target[i] - arr[i];
        }
        return XOR == 0 && sum == 0;
    }

    public static boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i])
                return false;
        }
        return true;
    }
}
