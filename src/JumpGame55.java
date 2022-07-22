import java.util.Arrays;

public class JumpGame55 {
    public static boolean canJump(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr,-1);
        if(jump(0,nums,arr)==1)
            return true;
        return false;


    }

    public static int jump(int i, int[] nums, int[] arr){
        if(i>=nums.length-1){
            return 1;
        }
        if(nums[i]==0){
            arr[i]=0;
            return 0;
        }
        if(arr[i]!=-1)
            return arr[i];
        int possible = 0;
        for(int j=nums[i];j>0;j--){
            possible = jump(i+j,nums,arr);
            if(possible==1)
                break;
        }
        arr[i] = possible;
        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
