import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
            {
                diff = i - map.get(nums[i]);
                if(diff<=k)
                    return true;
                map.put(nums[i],i);
            }
            else
                map.put(nums[i],i);
        }

        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    /*
    *
    * Intuition

Keep a sliding window of kkk elements using Hash Table.

Algorithm

From the previous approaches, we know that even logarithmic performance in search is not enough. In this case, we need a data structure supporting constant time search, delete and insert operations. Hash Table is the answer. The algorithm and implementation are almost identical to Approach #2.

    Loop through the array, for each element do
        Search current element in the HashTable, return true if found
        Put current element in the HashTable
        If the size of the HashTable is larger than kkk, remove the oldest item.
    Return false

    * */

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        System.out.println(containsNearbyDuplicate2(nums, 1));
    }
}
