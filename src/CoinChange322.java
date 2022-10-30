import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange322 {
    //top down
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

    //bottom up
    public static  int coinChange2(int[] coins, int amount) {
        int amt = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amt);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i)
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }

        return dp[amount];
    }

    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //Arrays.fill(dp,-1);
        return coinChange3(coins, amount, dp);
    }

    public static int coinChange3(int[] coins, int amount, int[] dp){
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;

        if(dp[amount]!=0)
            return dp[amount];

        int val=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int min = coinChange3(coins, amount-coins[i],dp);
            if(min>=0 && min<val)
                val = min+1;
        }

        dp[amount]=(val==Integer.MAX_VALUE) ?-1:val;
        return dp[amount];
    }

    public static int coinChange4(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return coinChange4(coins, amount, dp);
    }
    public static int coinChange4(int[] coins, int amount, int[] dp){
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(dp[amount]!=0)
            return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length;i++){
            if(amount==21)
            System.out.println(amount);
            int res = coinChange4(coins, amount-coins[i],dp);
            if(res<min && res>=0)
                min = 1 + res;
        }
        dp[amount]=min==Integer.MAX_VALUE?-1:min;
        return min==Integer.MAX_VALUE?-1:min;
    }

    public static void main(String[] args) {
        System.out.println(coinChange4(new int[]{186,419,83,408}, 6249));
    }
}
