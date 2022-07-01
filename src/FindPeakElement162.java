public class FindPeakElement162 {

    //my solution
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(mid>0 && mid<nums.length-1){
                if(nums[mid]>nums[mid+1] && nums[mid-1]<nums[mid])
                    return mid;
                else if(nums[mid+1]>nums[mid])
                    start=mid+1;
                else if(nums[mid-1]>nums[mid])
                    end = mid-1;
            }
            else{
                if(mid==0){
                    if(nums[mid+1]>nums[mid])
                        return mid+1;
                    else
                        return mid;
                }
                else if(mid==nums.length-1){
                    if(nums[mid]>nums[mid-1])
                        return mid;
                    else
                        return mid-1;
                }
            }

        }

        return start;
    }
    //
    public static int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
            int[] arr= new int[]{5,4,3,4,5};
        System.out.println(findPeakElement(arr));
    }
}
