import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast)
                break;
        }

        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    //hashing
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a:nums){
            if(set.contains(a))
                return a;
            set.add(a);
        }
        return 0;
    }
}
