public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int bkt = 1;
        int prev = 1;

        for(int i=0;i<nums.length;i++){
            bkt = bkt*prev;
            res[i] = bkt;
            prev = nums[i];
        }

        prev = 1;
        bkt = 1;
        for(int i=nums.length-1;i>=0;i--){
            bkt = bkt*prev;
            res[i] = res[i]*bkt;
            prev = nums[i];
        }

        return res;

    }
}
