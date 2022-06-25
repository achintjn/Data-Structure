import java.util.Arrays;

public class HouseRobber198 {

    public static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private static int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        int a = rob(nums, i - 2) + nums[i];
        int b = rob(nums, i - 1);

        return Math.max(a, b);
    }
    private  int[] arr;

    public   int rob3(int[] nums) {
        this.arr = new int[nums.length+1];
        Arrays.fill(this.arr, -1);
        return maxi(0,nums);
    }

    private   int maxi(int i, int[] nums) {


        //if(i==nums.length-1 || i==nums.length-2)
        //return nums[i];
        if(i>=nums.length)
            return 0;
        if(this.arr[i]>-1)
            return arr[i];


        int ans = Math.max(nums[i] + maxi(i+2,nums), maxi(i+1,nums));
        this.arr[i] = ans;
        return ans;
    }

    private int[] memo;

    public  int rob2(int[] nums) {

        this.memo = new int[100];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);

        return this.robFrom(0, nums);
    }

    private  int robFrom(int i, int[] nums) {

        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }

        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }

        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);

        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] arr2 = new int[]{1,2,3,1};
        HouseRobber198 hr = new HouseRobber198();
        System.out.println(hr.rob3(arr2));
        long end1 = System.nanoTime();
        System.out.println(hr.rob2(arr));
        long end2 = System.nanoTime();
        System.out.println(hr.rob3(arr));
        long end3 = System.nanoTime();

        System.out.println(end2-end1);
        System.out.println(end3-end2);
    }
}
