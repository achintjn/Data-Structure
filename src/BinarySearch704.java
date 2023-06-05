public class BinarySearch704 {
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left<=right){
            mid = (left+right)/2;
            if(target==nums[mid])
                return mid;
            else if(target>nums[mid])
                left = mid+1;
            else
                right = mid-1;
        }

        return -1;


    }

    public static int search2(int[] nums, int target) {

        int first = 0;
        int last = nums.length - 1;
        int mid;

        while(first<=last){
            //mid=(last - first + 1) / 2;
            mid = first + (last-first) / 2;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                first = mid+1;
            else
                last = mid-1;
        }
        return -1;
    }

    public int search3(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int i = start+(end-start)/2;
            if(nums[i]==target)
                return i;
            else if(nums[i]>target)
                end = i-1;
            else
                start = i+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] inp = {5};

        System.out.println(search2(inp,5));
    }
}
