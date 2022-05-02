import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {
    public static int climbStairs(int n) {

        Map<Integer, Integer> map = new HashMap<>();

        //int count = 0;

        return climbStairsDP(n, map);

    }

    public static int climbStairsDP(int n, Map<Integer, Integer> map){

        int one=0;
        int two=0;

        if(n<0)
            return 0;

        if(n==0)
            return 1;

        if(map.containsKey(n))
            return map.get(n);
        else {
            one = climbStairsDP(n - 1, map);
            two = climbStairsDP(n - 2, map);
        }

        map.put(n, one+two);

        return one + two ;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
