public class LongestIncreasingSubsequence300 {

    //top down approach using recursion
    public static int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int max =0;
        memo[nums.length-1]=1;
        for(int i=0; i<nums.length;i++){
            max = Math.max(lengthOf(nums, memo, i),max);
        }
        return max;
    }

    public static int lengthOf(int[] nums, int[] memo, int index){

        if(memo[index]!=0)
            return memo[index];

        int max=1;
        for(int i=index; i<nums.length;i++){
            if(index!=nums.length-1 && nums[index]<nums[i])
                max = Math.max(max,1 + lengthOf(nums, memo, i));
        }
        memo[index]=max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
