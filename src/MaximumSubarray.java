public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum = Math.max(nums[i],sum + nums[i]);
            max = Math.max(sum,max);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int omax=nums[0];  // omax: overall maximum
        int cmax=nums[0]; //  cmax: current maximum

        for(int i=1;i<nums.length;i++){
            cmax=Math.max(nums[i],nums[i] + cmax);

            omax=Math.max(cmax,omax);
        }
        return omax;
    }


    public static void main(String[] args) {

        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int arr1[] = {4,2,-5,2,7};
        int arr2[] = {5,4,-1,7,8};

        System.out.println(maxSubArray1(arr));
        System.out.println(maxSubArray(arr));

    }
}


