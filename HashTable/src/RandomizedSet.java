import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    HashSet<Integer> hashSet;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.hashSet = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.hashSet.contains(val))
            return false;
        this.hashSet.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!this.hashSet.contains(val))
            return false;
        hashSet.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int random = new Random().nextInt(hashSet.size());
        return new ArrayList<>(hashSet).get(random);
    }
}