public class SearchInRotatedSortedArray33 {

    //idea is right bu the solution is wrong
    public static int search(int[] nums, int target) {
        int len = nums.length-1;
        int start =0;
        int end = len;
        int mid = len/2;

        if(len==0){
            if(nums[0]==target)
                return 0;
            else
                return -1;
        }
        else if(len ==-1)
            return -1;

        while(start<end){
            if(nums[mid]>nums[start] && nums[mid]>nums[end])
                start = mid;
            else if(nums[mid]<nums[end] && nums[mid]<nums[start])
                end = mid;
            else if(nums[mid]==nums[start]) {
                mid = start;
                break;
            }
            else if(nums[mid]==nums[end]){
                mid = end;
                break;
            }
            mid = (start+end)/2;
        }

        int pivot ;

        if(nums[mid]>nums[mid+1])
            pivot = mid+1;
        else
            pivot = mid;

        if(pivot==0){
            start=0;
            end=len;
        }
        else if(target>=nums[pivot] && target<=nums[len]){
            start= pivot;
            end = len;
        }
        else if(target<nums[pivot-1] && target>=nums[0]){
            start = 0;
            end = pivot-1;
        }
        mid = (start+end)/2;
        while(start<=end){
            if(target>nums[mid])
                start = mid+1;
            if(target<nums[mid])
                end = mid-1;
            if(nums[mid]==target)
                return mid;

            mid = (start+end)/2;
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end - start) / 2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[start]){
                if(target<nums[mid] && target>=nums[start])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else{
                if(target>nums[mid] && target<=nums[end])
                    start=mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }

    public static int search3(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {3,1};
        System.out.println(search2(arr,1));
    }
}
