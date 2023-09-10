public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {

        int left=0;
        int right = nums.length;

        while(left<right){
            if(nums[left]==val)
            {
                //int temp = nums[left];
                nums[left] = nums[right-1];
                //nums[right] = temp;
                right--;
            }
            else
                left++;
        }

        return left;
    }
}
