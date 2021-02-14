public class SubArraysWithKDistinct {
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(A, k));

    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithDistink(A, K) - atMostWithDistink(A, K - 1);
    }

    private static int atMostWithDistink(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        int count = 0;
        while (left < right) {
            if (freq[A[right]] == 0) {

            }
        }

        return 0;
    }
}
