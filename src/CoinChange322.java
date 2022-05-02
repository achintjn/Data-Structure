import java.util.HashMap;
import java.util.Map;

public class CoinChange322 {
    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();

        int m = coinChange(coins, amount, map);
        return m;
    }

    public static int coinChange(int[] coins, int amount, Map<Integer, Integer> map){
        if(amount ==0)
            return 0;

        if(amount<0)
            return -1;

        if(map.containsKey(amount))
            return map.get(amount);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int a = coinChange(coins, amount - coins[i], map) + 1;
            if(a>=0)
                min = Math.min(min, a);
        }

        map.put(amount, min);

        return min;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
