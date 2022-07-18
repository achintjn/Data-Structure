import java.util.*;

public class PermutationII47 {
    /*public static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int a:nums)
            list2.add(a);

        backtrack(0,list,list2,nums);
        return list;

    }

    public static void backtrack(int n, ArrayList<List<Integer>> list,ArrayList<Integer> list2, int[] nums){
        if(n==nums.length)
            list.add(new ArrayList(list2));

        for(int i=n;i<nums.length;i++){
            if(i<nums.length-1 && list2.get(i+1)==list2.get(i))
                continue;
            Collections.swap(list2,n,i);
            backtrack(n+1,list,list2,nums);
            Collections.swap(list2,n,i);
        }

    }*/

    /*public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, counter, results);
        return results;
    }

    *//*protected static void backtrack( LinkedList<Integer> comb, Integer N,
                                     HashMap<Integer, Integer> counter, List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }*/

    public static void traverse(List<List<Integer>> resultList, List<Integer> current, int[] nums, boolean[] used) {
        if( current.size() == nums.length )
            resultList.add(new ArrayList<Integer>(current));
        else{
            for(int i = 0; i < nums.length; i++) {
                if( used[i] || ( i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) ) // remove duplicate
                    continue;
                current.add(nums[i]);
                used[i] = true;
                traverse(resultList, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort is necessary
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        traverse(resultList, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2,2}));
    }
}
