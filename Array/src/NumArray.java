class NumArray {
    private final int[] sums;

    public NumArray(int[] nums) {
        int sum = 0, len = nums.length;
        sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}