import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate1 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for(int i = 0; i<nums.length ; i++)
        {

            if(map.containsKey(nums[i])){
                flag = true;
                return flag;
            }
            else{
                map.put(nums[i],1);
            }
        }
        return flag;
    }

    public static void main(String[] args) {



    }
}
