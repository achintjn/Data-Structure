public class IntegerBreak343 {
    public static int integerBreak(int n) {
        int [] dp = new int[n+1];
        return intBreak(n,dp,0);
    }

    public static int intBreak(int n,int[] dp, int remain){

        if(n==1)
            return 1;
        /*if(n==3)
            return 2;
        if(n==4)
            return 4;*/
        if(dp[n]>0)
            return Math.max(dp[n]*remain,n*remain);

        int max=0;
        for(int i=1;i<(n/2)+1;i++){
            max = Math.max(intBreak(n-i,dp,i), max);
            //dp[n]=max;
        }
        dp[n]=max;
        return Math.max(max,n*remain);
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(3));
    }
}
