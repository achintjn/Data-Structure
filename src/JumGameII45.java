import java.util.Arrays;

public class JumGameII45 {
    public static int jump(int[] nums) {
        int[]  arr = new int[nums.length];
        Arrays.fill(arr,-1);
        arr[nums.length-1]=0;
        return jump(nums, 0,arr);

    }

    public static int jump(int[] nums, int i, int[] arr){
        if(i>=nums.length-1)
            return 0;
        if(nums[i]==0)
            return 100000;
        if(arr[i]!=-1)
            return arr[i];
        int min = Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            min= Math.min(jump(nums, i+j,arr)+1,min);
        }
        arr[i]=min;

        return arr[i];
    }

    //leetcode optimized solution with O(n) complexity
    public static int jump2(int[] nums) {
        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump2(new int[]{2,3,0,1,4}));
    }
}
