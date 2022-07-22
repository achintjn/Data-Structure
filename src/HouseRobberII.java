import java.util.Arrays;

public class HouseRobberII {
    public static int rob(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int[] arr2 = new int[len];

        Arrays.fill(arr,-1);
        Arrays.fill(arr2,-1);
        if(len==1)
            return nums[0];
        return Math.max(rob(nums,0, len-2,arr),rob(nums,1, len-1, arr2));
    }

    public static int rob(int[] nums,int i, int end, int[] arr){
        if(i>end)
            return 0;
        if(arr[i]!=-1){
            //System.out.println("yes");
            return arr[i];
        }


        arr[i] = Math.max(nums[i]+rob(nums,i+2, end,arr),rob(nums,i+1, end,arr));
        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
