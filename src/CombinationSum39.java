import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> list= new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int count=0;
        combine(0,candidates,target, list, list2,count);
        return list;
    }

    public static void combine(int n,int[] candidates, int target,LinkedList<List<Integer>> list,LinkedList<Integer> list2, int count){
        if(count==target)
            list.add(new LinkedList(list2));
        for(int i=n;i<candidates.length;i++){
            list2.add(candidates[i]);
            count = count+candidates[i];
            if(target-count>=candidates[i])
                combine(i,candidates,target, list, list2,count);
            else if(i<candidates.length-1 && target-(count+candidates[i+1])>=0)
                combine(i+1,candidates,target, list, list2,count);
            else if(count==target)
                combine(i+1,candidates,target, list, list2,count);
            count = count-candidates[i];
            list2.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
