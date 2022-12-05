public class MinimumSizeSubArraySum209 {
    /*
    Intuition

Until now, we have kept the starting index of subarray fixed, and found the last position.
Instead, we could move the starting index of the current subarray as soon as we know that no better
could be done with this index as the starting index. We could keep 2 pointer,one for the start and
another for the end of the current subarray, and make optimal moves
so as to keep the sum\text{sum}sum greater than sss as well as maintain the lowest size possible.

Algorithm

    Initialize left\text{left}left pointer to 0 and sum\text{sum}sum to 0
    Iterate over the nums\text{nums}nums:
        Add nums[i]\text{nums}[i]nums[i] to sum\text{sum}sum
        While sum\text{sum}sum is greater than or equal to sss:
        Update ans=min⁡(ans,i+1−left)\text{ans}=\min(\text{ans},i+1-\text{left})ans=min(ans,i+1−left), where i+1−lefti+1-\text{left}i+1−left is the size of current subarray
        It means that the first index can safely be incremented, since, the minimum subarray starting with this index with sum≥s\text{sum} \geq ssum≥s has been achieved
        Subtract nums[left]\text{nums[left]}nums[left] from sum\text{sum}sum and increment left\text{left}left



     */

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

    //revise
    public int minSubArrayLen2(int target, int[] nums) {
        int sum=0;
        int right=0;
        int left=0;
        int size=nums.length+1;
        while(right<nums.length){
            sum = sum+nums[right];
            while(sum>=target){
                if(right-left+1<size)
                    size=right-left+1;
                sum = sum-nums[left];
                left++;
            }
            right++;
        }
        if(size==nums.length+1)
            return 0;
        return size;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
