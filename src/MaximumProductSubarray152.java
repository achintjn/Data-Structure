public class MaximumProductSubarray152 {

    //solution 1 my first attempt
    public int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prod = 1;
        int cont_prod = 1;
        int right=0;
        while(right<nums.length){
            if(nums[right]==0){
                prod = 1;
                cont_prod=1;
                max = Math.max(max,0);
            }
            else{
                cont_prod = cont_prod * nums[right];
                prod = Math.max(prod * nums[right],nums[right]);

                max = Math.max((Math.max(prod,max)),cont_prod);
            }
            right++;
        }
        prod = 1;
        cont_prod = 1;
        right = nums.length-1;
        while(right>0){
            if(nums[right]==0){
                prod = 1;
                cont_prod=1;
                max = Math.max(max,0);
            }
            else{
                cont_prod = cont_prod * nums[right];
                prod = Math.max(prod * nums[right],nums[right]);

                max = Math.max((Math.max(prod,max)),cont_prod);
            }
            right--;
        }
        return max;
    }


    //solution 2 more clean of my logic
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;

        int product=1;

        for(int num : nums){
            product *= num;
            max = Math.max(product,max);
            if(product == 0)product = 1;

        }

        product = 1;
        for(int i=nums.length-1;i>=0;i--){
            product *= nums[i];
            max = Math.max(product,max);
            if(product ==0) product = 1;
        }

        return max;
    }

    //leetcode logic of dynamic programming
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];

        int prod = 1;
        int right = 1;
        int res = max;
        while(right<nums.length){
            int curr = nums[right];
            int tempmax = Math.max(Math.max(curr,min*curr),max*curr);
            min = Math.min(Math.min(curr,min*curr),max*curr);
            max = tempmax;
            res = Math.max(res, tempmax);
            right++;

        }
        return res;
    }
}
