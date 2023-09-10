public class RemoveDuplicatesFromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        int prev=nums[0];
        int i=2;
        for(int n=2;n<nums.length;n++){

            if(prev!=nums[n]){
                prev = nums[n-1];
                nums[i]=nums[n];
                i++;
            }
            else
                prev = nums[n-1];
        }
        return i;
    }
}
