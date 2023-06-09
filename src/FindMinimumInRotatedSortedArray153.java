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


    public int findMin2(int[] nums) {
        int start = 0;
        int end =  nums.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>=nums[start] && nums[mid]>nums[end])
                start = mid +1;
            else if(nums[mid]<=nums[start] && nums[mid]<nums[end])
                end = mid;
            else if(nums[mid]>=nums[start] && nums[mid]<nums[end])
                return nums[start];
        }
        return nums[start];
    }

    //shortest
    public int findMin3(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]>=nums[start] && nums[mid]>nums[end])
                start=mid+1;
            else
                end = mid;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] arr= new int[]{3,1,2};
        System.out.println(findMin(arr));
    }
}
