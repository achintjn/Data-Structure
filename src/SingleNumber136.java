import java.util.HashSet;
import java.util.Set;

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int a=0;
        for(int x:nums){
            if(set.contains(x))
                a=a-x;
            else{
                set.add(x);
                a=a+x;
            }

        }

        return a;
    }
}
