public class BestTimeToBuyAndSellStock122 {
    public static int maxProfit(int[] prices) {
        int total = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;;

        for(int i=0; i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
                total = total + max;
            }
            else{
                if(prices[i]-min>max){
                    max = prices[i] - min;

                }
                else
                {
                    total = total + max;
                    max = -1;
                    min = prices[i];
                }
            }
        }

        if(total<=0 && max>0)
            total = max;
        else if(total>0 && max>0)
            total =total + max;
        if(total<=0 && max<=0)
            return 0;
        return total;
    }

    public static void main(String[] args) {
        int [] arr = {2,1,2,0,1};

        System.out.println(maxProfit(arr));
    }
}
