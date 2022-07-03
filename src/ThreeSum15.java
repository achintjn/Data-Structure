import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

    //my solution
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> final1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int zero = 0;
        Integer target=null;
        for(int i=0;i<nums.length-2;i++){
            if(target==null || target!=(zero-nums[i]))
                target = zero-nums[i];
            else
                continue;
            int start=i+1;
            int end=nums.length-1;

            while(start<end){
                list.clear();
                int a = nums[start] + nums[end];
                if(a==target){
                    list.add(nums[start]);
                    list.add(nums[end]);
                    list.add(nums[i]);
                    final1.add(new ArrayList(list));
                    while(start!=nums.length-1 && nums[start]==nums[start+1]){
                        start=start+1;
                    }
                    start++;
                }
                if(a>target){
                    end--;
                }
                if(a<target)
                    start++;
            }

        }

        return final1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0};
        threeSum(arr);
    }
}
