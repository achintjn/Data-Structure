import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfLongestIncreasingSubsequence673 {
    public static int findNumberOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int max =0;
        Arrays.fill(memo,1);
        int[] cnt = new int[nums.length];
        cnt[nums.length-1]=1;
        Arrays.fill(cnt,1);


        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    if(memo[i]==1+memo[j])
                        cnt[i]=cnt[i]+cnt[j];
                    else if(memo[i]<1+memo[j])
                    {cnt[i]=cnt[j];
                        memo[i]=1+memo[j];}
                }
            }
            max=Math.max(max,memo[i]);
        }
        int num=0;
        if(max==1)
            return nums.length;
        for(int i=0;i<nums.length;i++){
            if(memo[i]==max)
                num=num+cnt[i];
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
    }
}
