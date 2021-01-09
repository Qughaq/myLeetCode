import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}, arr2 = {1, 2, 5, 7, 9}, arr3 = {1, 3, 4, 5, 8};
        System.out.println(arraysIntersection(arr1, arr2, arr3));
    }

    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0)
            return -1;
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int result = Integer.MIN_VALUE;
        while (l < r) {
            if (A[l] + A[r] >= K) {
                r--;
            } else {
                result = Math.max(result, A[l] + A[r]);
                l++;
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int arr : arr1)
            set1.add(arr);
        for (int arr : arr2)
            if (set1.contains(arr))
                set2.add(arr);
        for (int arr : arr3)
            if (set2.contains(arr)) result.add(arr);
        return result;
    }

    public static List<Integer> arraysIntersection1(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int arr : arr1)
            freq.put(arr, freq.getOrDefault(arr, 0) + 1);
        for (int arr : arr2)
            freq.put(arr, freq.getOrDefault(arr, 0) + 1);
        for (int arr : arr3)
            freq.put(arr, freq.getOrDefault(arr, 0) + 1);
        Set<Integer> keys = freq.keySet();
        for (int key : keys)
            if (freq.get(key) == 3)
                result.add(key);
        return result;
    }
}
