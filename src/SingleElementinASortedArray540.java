public class SingleElementinASortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(end>start){
            int mid = (start+end)/2;

            if(mid%2==1)
                mid--;
            if(nums[mid]==nums[mid+1])
                start = mid+2;
            else
                end = mid;
        }
        return nums[start];
    }
}
