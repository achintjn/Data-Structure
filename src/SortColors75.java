public class SortColors75 {
    class Solution {
        public void sortColors(int[] nums) {
            int zero = 0;
            int two = nums.length-1;
            int move = zero;
            while(move<=two){
                if(nums[move]==2){
                    swap(nums,two,move);
                    two--;
                }
                else if(nums[move]==0){
                    swap(nums,zero,move);
                    zero++;
                    move++;
                }
                else
                    move++;
            }
        }

        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
