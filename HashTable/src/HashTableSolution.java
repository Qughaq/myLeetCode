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

//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};
//        System.out.println(Arrays.toString(intersect(nums1, nums2)));

//        int[] nums = {99, 99};
//        int k = 2;
//        System.out.println(containsNearbyDuplicate(nums, k));

//        String[] strs = {};
//        System.out.println(groupAnagrams(strs));


//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        System.out.println(isValidSudoku(board));


//        String J = "aA";
//        String S = "ZZZ";
//        System.out.print(numJewelsInStones(J, S));

//        String s = "bbbbb3";
//        System.out.println(lengthOfLongestSubstring(s));

//        int[] A = {1, 2};
//        int[] B = {-2, -1};
//        int[] C = {-1, 2};
//        int[] D = {0, 2};
//        System.out.println(fourSumCount(A, B, C, D));
//

//        int[] nums = {1, 2, 1, 2, 3, 4, 5, 6, 6, 6};
//        int k = 2;
//        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int[][] result = new int[hashMap.size()][2];
        Object[] keys = hashMap.keySet().toArray();
        Object[] values = hashMap.values().toArray();
        for (int i = 0; i < keys.length; i++) {
            result[i][0] = (int) keys[i];
            result[i][1] = (int) values[i];
        }
        Arrays.sort(result[2]);
        return result[1];
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int numA : A)
            for (int numB : B) {
                int sumAB = numA + numB;
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        for (int numC : C)
            for (int numD : D) {
                int sumDC = numC + numD;
                if (map.containsKey(-sumDC))
                    count += map.get(-sumDC);
            }
        return count;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int slow = 0, fast = 0, max = 0;
        while (fast < s.length()) {
            if (!seen.contains(s.charAt(fast))) {
                seen.add(s.charAt(fast++));
                max = Math.max(seen.size(), max);
            } else {
                seen.remove(s.charAt(slow++));
            }
        }
        return max;
    }

    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));
        int count = 0;
        for (int i = 0; i < S.length(); i++)
            if (jewels.contains(S.charAt(i)))
                count++;
        return count;
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.')
                    if (!seen.add(current + "出现在行" + i)
                            || !seen.add(current + "出现在列" + j)
                            || !seen.add(current + "出现在子箱" + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!hashMap.containsKey(sortedStr))
                hashMap.put(sortedStr, new ArrayList<>());
            hashMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (i - hashMap.get(nums[i]) <= k)
                    return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int num1 : nums1) {
            if (hashMap.containsKey(num1)) {
                hashMap.put(num1, hashMap.get(num1) + 1);
            } else hashMap.put(num1, 1);
        }
        for (int num2 : nums2) {
            if (hashMap.containsKey(num2)) {
                resultList.add(num2);
                hashMap.put(num2, hashMap.get(num2) - 1);
                if (hashMap.get(num2) == 0) {
                    hashMap.remove(num2);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
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
