public class MinimumSizeSubArraySum209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int right =0;
        int left=0;
        int min = Integer.MAX_VALUE;
        int sum=0;
        int len=0;
        while(right<nums.length){
            sum = sum+nums[right];
            if(sum>=target){
                len= right-left+1;
                while(sum>=target){
                    min = Math.min(len,min);
                    sum = sum-nums[left];
                    left++;
                    len = right-left+1;
                }

                //min=len;
            }
            right++;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
