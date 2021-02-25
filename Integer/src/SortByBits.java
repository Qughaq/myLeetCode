import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByBits {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    public static int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }

    public static int[] sortByBits1(int[] arr) {
        int[] bit = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
            bit[num] = getOneCount(num);
        }
        list.sort((x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        Arrays.setAll(arr, list::get);
        return arr;
    }

    public static int getOneCount(int x) {
        int count = 0;
        while (x != 0) {
            count += x % 2;
            x /= 2;
        }
        return count;
    }
}
