public class IsMonotonic {
    public static void main(String[] args) {
        int[] A = {6, 5, 4, 4};
        System.out.println(isMonotonic(A));
    }

    public static boolean isMonotonic(int[] A) {
        int len = A.length;
        int countIncrease = 0, countDecrease = 0;
        for (int i = 0; i < len - 1; i++) {
            if (A[i] <= A[i + 1])
                countIncrease++;
            if (A[i] >= A[i + 1])
                countDecrease++;
        }
        return countIncrease == len - 1 || countDecrease == len - 1;
    }
}
