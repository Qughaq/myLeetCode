public class MaxSubarraySumCircular {
    public static void main(String[] args) {
        int[] A = {3, -1, 2, -1};
        System.out.println(maxSubarraySumCircular(A));
    }

    public static int maxSubarraySumCircular(int[] A) {
        int last = A[0];
        int sum = last, max = last, min = 0;
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            last = last < 0 ? A[i] : last + A[i];
            max = Math.max(max, last);
        }
        last = 0;
        for (int i = 1; i < A.length - 1; i++) {
            last = last > 0 ? A[i] : last + A[i];
            min = Math.min(min, last);
        }
        return Math.max(max, sum - min);
    }
}
