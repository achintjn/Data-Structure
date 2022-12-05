public class SubArrayProductLessThanK713 {


    //logrithm solution
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
                else hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }

    //my solution after seeing solution
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(k<=1)
            return 0;
        int right=0;
        int left=0;
        int product=1;
        int result=0;
        while(right<nums.length){
            product = product*nums[right];
            while(product>=k){
                product=product/nums[left];
                left++;
            }
            result=result+(right-left+1);
            right++;
        }
        return result;

    }

    //revise
    public static int numSubarrayProductLessThanK3(int[] nums, int k) {
        if(k<=1)
            return 0;
        int prod = 1;

        int count = 0;
        int right = 0;
        int left = 0;
        while(right<nums.length){
            prod=prod*nums[right];
            while(prod>=k){
                prod=prod/nums[left];
                left++;
            }
            count = count + (right-left+1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK3(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3},19));
    }
}
