import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashTableSolution {
    public static void main(String[] args) {
//        MyHashSet hashSet = new MyHashSet();
//        hashSet.add(1);
//        hashSet.add(2);
//        hashSet.contains(1);    // returns true
//        hashSet.contains(3);    // returns false (not found)
//        hashSet.add(2);
//        hashSet.contains(2);    // returns true
//        hashSet.remove(2);
//        hashSet.contains(2);    // returns false (already removed)
//
//        MyHashMap hashMap = new MyHashMap();
//        hashMap.put(1, 1);
//        hashMap.put(2, 2);
//        hashMap.get(1);            // returns 1
//        hashMap.get(3);            // returns -1 (not found)
//        hashMap.put(2, 1);          // update the existing value
//        hashMap.get(2);            // returns 1
//        hashMap.remove(2);          // remove the mapping for 2
//        hashMap.get(2);            // returns -1 (not found)

//        int[] arr1 = {4, 1, 2, 1, 2};
//        int[] arr2 = {4, 1, 3, 4, 7, 9, 9, 9, 9, 2, 2, 2, 2};
//        System.out.println(Arrays.toString(intersection(arr1, arr2)));

//        int n = 2;
//        System.out.println(isHappy(n));

//        String s = "ab";
//        String t = "ca";
//        System.out.println(isIsomorphic(s, t));

//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"KNN", "KFC", "Burger King", "Tapioca Express", "Shogun"};
//        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

//        String s = "leetcode";
//        System.out.println(firstUniqChar(s));

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        return null;
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            else
                hashMap.put(s.charAt(i), 1);
        }
        for (int i = 0; i < s.length(); i++)
            if (hashMap.get(s.charAt(i)) == 1)
                return i;
        return -1;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> resultList = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++)
            hashMap.put(list1[i], i);
        for (int i = 0; i < list2.length; i++)
            if (hashMap.containsKey(list2[i])) {
                if (minIndexSum > i + hashMap.get(list2[i])) {
                    minIndexSum = i + hashMap.get(list2[i]);
                    resultList.clear();
                    resultList.add(list2[i]);
                } else if (minIndexSum == i + hashMap.get(list2[i])) {
                    resultList.add(list2[i]);
                }
            }
        return resultList.toArray(new String[0]);
    }

    public static Object getKey(HashMap map, Object value) {
        List<Integer> keyList = new ArrayList<>();
        for (Object key : map.keySet()) {
            if (map.get(key).equals(value)) {
                keyList.add((Integer) key);
            }
        }
        return keyList;
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != hashMap.get(s.charAt(i))) {
                    return false;
                }
            } else if (hashMap.containsValue(t.charAt(i))) {
                return false;
            } else {
                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            n = sumOfSquaresOfDigits(n);
            if (n == 1) return true;
        }
        return false;
    }

    public static int sumOfSquaresOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num = num / 10;
        }
        return sum;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> tempSet1 = new HashSet<>();
        HashSet<Integer> tempSet2 = new HashSet<>();
        for (int num1 : nums1) {
            tempSet1.add(num1);
        }
        for (int num2 : nums2) {
            if (tempSet1.contains(num2)) {
                tempSet2.add(num2);
            }
        }
        int[] result = new int[tempSet2.size()];
        Iterator<Integer> iterator = tempSet2.iterator();
        for (int i = 0; i < tempSet2.size(); i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            if (hashset.contains(num))
                hashset.remove(num);
            else
                hashset.add(num);
        }
        return hashset.iterator().next();
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            if (hashset.contains(num)) return true;
            hashset.add(num);
        }
        return false;
    }
}
