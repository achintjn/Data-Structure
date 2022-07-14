import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII90 {

    //backtracking
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        LinkedList<List<Integer>> list= new LinkedList<>();
        LinkedList<Integer> list2 =  new LinkedList<>();
        Arrays.sort(nums);
        subsets(0, nums, list, list2);
        return list;
    }

    public static void subsets(int n, int[] nums,LinkedList<List<Integer>> list,LinkedList<Integer> list2){

        //if(!(list.contains(list2)))
            list.add(new LinkedList(list2));

        for(int i=n;i<nums.length;i++){

            if (i != n && nums[i] == nums[i - 1]) {
                continue;
            }

            list2.add(nums[i]);
            subsets(i+1, nums, list, list2);
            list2.removeLast();
        }
    }
    //need to work on this
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> list= new LinkedList<>();
        LinkedList<Integer> list2 =  new LinkedList<>();
        list.add(list2);

        int x = 0;

        for(int i:nums){
            if(i==x)
                continue;
            else
                x=i;
            LinkedList<List<Integer>> local= new LinkedList<>();
            for(List<Integer> a:list){
                local.add(new LinkedList<Integer>(a){{add(i);}});
            }
            for(List<Integer> a:local){
                list.add(a);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
