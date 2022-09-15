import java.util.*;

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

    public static boolean containsDuplicate2(int [] nums) {
        //List<Integer> list = Arrays.asList(nums);

        List<Integer> intList = new ArrayList<Integer>(nums.length);
        for (int i : nums)
        {
            intList.add(i);
        }
        Set<Integer> set = new HashSet<>(intList);

        if(set.size()==nums.length)
            return false;
        else
            return true;

    }

    public static boolean containsDuplicate3(int[] nums) {
        List<Integer> intList = new ArrayList<Integer>(nums.length);
        for (int i : nums)
        {
            intList.add(i);
        }

        Set set = new HashSet(intList);
        System.out.println(set);
        if(nums.length!=set.size())
            return true;

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(containsDuplicate3(nums));


    }
}
