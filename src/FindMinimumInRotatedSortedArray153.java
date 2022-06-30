public class FindMinimumInRotatedSortedArray153 {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[start] && nums[mid]>nums[end])
                start = mid;
            else if(nums[mid]<nums[start] && nums[mid]<nums[end])
                end = mid;
            else
                break;
        }

        return Math.min(nums[start],nums[end]);
    }

    public static void main(String[] args) {
        int[] arr= new int[]{3,1,2};
        System.out.println(findMin(arr));
    }
}
