class BinarySearch {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(target!=nums[(left+right)/2] && left!=right){
            if(target<nums[(left+right)/2])
                right = (left+right)/2;
            else
                left = (left+right)/2;
        }

        if(target==nums[right])
            return right;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] inp = [-1,0,3,5,9,12];

        System.out.println(search(inp,9));
    }
}