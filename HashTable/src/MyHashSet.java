public class MyHashSet {
    /**
     * Initialize your data structure here.
     */
    boolean[] set = new boolean[1000005];

    public MyHashSet() {
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */