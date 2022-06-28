public class FindFirstAndLastPosition34 {
    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        if(end==-1)
            return new int[]{-1,-1};

        int first_index = findFirst(start, end, nums, target);
        int last_index = findLast(start, end, nums, target);
        System.out.println(first_index+" "+last_index);

        return new int[]{first_index, last_index};

    }

    public static int findFirst(int start, int end, int[] nums, int target){
        int mid = nums.length/2;

        while(end>start+1){
            if(nums[mid]>=target)
                end = mid;
            if(nums[mid]<target)
                start=mid;
            mid = (start+end)/2;
        }
        if(nums[start]==target)
            return start;
        if(nums[end]==target)
            return end;
        else
            return -1;
    }

    public static int findLast(int start, int end, int[] nums, int target){
        int mid = nums.length/2;

        while(end>start+1){
            if(nums[mid]>target)
                end = mid;
            if(nums[mid]<=target)
                start=mid;
            mid = (start+end)/2;
        }

        if(nums[end]==target)
            return end;
        if(nums[start]==target)
            return start;
        else
            return -1;
    }

    public static void main(String[] args) {
            searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
