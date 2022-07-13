import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII90 {

    //backtracking
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        LinkedList<List<Integer>> list= new LinkedList<>();
        LinkedList<Integer> list2 =  new LinkedList<>();
        Arrays.sort(nums);
        subsets(0, nums, list, list2);
        return list;
    }

    public void subsets(int n, int[] nums,LinkedList<List<Integer>> list,LinkedList<Integer> list2){

        if(!(list.contains(list2)))
            list.add(new LinkedList(list2));

        for(int i=n;i<nums.length;i++){
            list2.add(nums[i]);
            subsets(i+1, nums, list, list2);
            list2.removeLast();
        }
    }
}
