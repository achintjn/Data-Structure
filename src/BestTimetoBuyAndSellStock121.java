import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BestTimetoBuyAndSellStock121 {
    public int maxProfitBrute(int[] prices) {
        int max = 0;
        for(int i=0; i<prices.length;i++){
            for(int j=i; j<prices.length;j++){
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        if( max>0)
            return max;
        else
            return 0;
    }
}
