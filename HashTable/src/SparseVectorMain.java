public class SparseVectorMain {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 0, 2, 3}, nums2 = {0, 3, 0, 4, 0};
        // Your SparseVector object will be instantiated and called as such:
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }
}
