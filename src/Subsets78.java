import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets78 {
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> curr = new LinkedList<>();
        //curr.add(nums[0]);
        backtrack(0,curr,nums);
        return output;
    }

    public void backtrack(int start, LinkedList<Integer> curr, int[] nums){

        output.add(new LinkedList(curr));
        for(int i = start;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(i+1,curr,nums);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        Subsets78 su = new Subsets78();
        su.subsets(nums);
    }
}
