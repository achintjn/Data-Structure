import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        comboSum(0,0,target,candidates,list,res);
        return res;
    }

    void comboSum(int a, int sum, int target, int[] candidates, LinkedList<Integer> list,List<List<Integer>> res){
        if(sum==target)
            res.add(new ArrayList<>(list));
        if(sum>target)
            return;

        for(int i=a;i<candidates.length;i++){
            if(i!=a && candidates[i]==candidates[i-1])
                continue;
            else{
                list.add(candidates[i]);
                comboSum(i+1,sum+candidates[i],target,candidates,list,res);
                list.removeLast();
            }
        }
    }
}
