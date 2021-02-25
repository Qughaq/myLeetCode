public class LongestMountain {

    public static void main(String[] args) {
        int[] arr = {2, 3};
        System.out.println(longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {
        int maxLen = 0;
        int len = arr.length;
        int i = 1;
        while (i < len) {
            int upHill = 0, downHill = 0;
            while (i < len && arr[i - 1] < arr[i]) {
                i++;
                upHill++;
            }
            while (i < len && arr[i - 1] > arr[i]) {
                i++;
                downHill++;
            }
            if (upHill > 0 && downHill > 0)
                maxLen = Math.max(maxLen, upHill + downHill + 1);
            while (i < len && arr[i - 1] == arr[i]) i++;
        }
        return maxLen;
    }
}
