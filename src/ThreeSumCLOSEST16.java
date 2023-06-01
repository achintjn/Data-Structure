import java.util.Arrays;

public class ThreeSumCLOSEST16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<nums.length;i++){
            int a = nums[i];

            int start = i+1;
            int end = nums.length-1;

            while(start<end){
                int c = nums[start]+nums[end];
                int sum = c+a;
                if(Math.abs(target-sum)<Math.abs(min)){
                    res=sum;
                    min = Math.abs(target-sum);
                }
                if(sum>target)
                    end--;
                else
                    start++;

                //start++;
            }
        }
        return res;
    }
}
