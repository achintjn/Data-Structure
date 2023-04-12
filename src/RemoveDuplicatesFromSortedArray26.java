public class RemoveDuplicatesFromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int prev = -101;
        int i = 0;
        for(int n:nums){
            if(prev!=n)
            {
                nums[i]=n;
                prev = n;
                i++;
            }
        }
        return i;
    }
}
