import java.util.HashMap;
import java.util.Set;

class SparseVector {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                this.hashMap.put(i, nums[i]);
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        Set<Integer> keys = vec.hashMap.keySet();
        for (int key : keys)
            if (this.hashMap.containsKey(key))
                result += this.hashMap.get(key) * vec.hashMap.get(key);
        return result;
    }
}