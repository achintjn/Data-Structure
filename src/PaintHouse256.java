public class PaintHouse256 {
        public int minCost(int[][] costs) {
            int[][] dp = new int[costs.length][costs[0].length];

            int one = minCost(costs, dp,0,0,Integer.MAX_VALUE);

            int two = minCost(costs, dp,1,0,Integer.MAX_VALUE);

            int three = minCost(costs,dp,2,0,Integer.MAX_VALUE);

            return Math.min(Math.min(one,two),three);
        }

        public int minCost(int[][] costs, int[][] dp, int i, int row, int min){

            if(row>=costs.length)
                return 0;
            if(dp[row][i]!=0)
                return dp[row][i];

            if(i==0)
                min = costs[row][i] + Math.min(minCost(costs, dp,1,row+1,min), minCost(costs, dp,2,row+1,min));
            if(i==1)
                min = costs[row][i] + Math.min(minCost(costs, dp,0,row+1,min), minCost(costs, dp,2,row+1,min));
            if(i==2)
                min = costs[row][i] + Math.min(minCost(costs, dp,1,row+1,min), minCost(costs, dp,0,row+1,min));

            dp[row][i] = min;
            return min;
        }

}
