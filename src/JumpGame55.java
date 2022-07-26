import java.util.Arrays;

public class JumpGame55 {
    //top down recursive approach
    int min  = Integer.MAX_VALUE;
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

    enum Index {
        GOOD, BAD, UNKNOWN
    }
        //leet code solution
        public static boolean canJump2(int[] nums) {
            Index[] memo = new Index[nums.length];
            for (int i = 0; i < memo.length; i++) {
                memo[i] = Index.UNKNOWN;
            }
            memo[memo.length - 1] = Index.GOOD;

            for (int i = nums.length - 2; i >= 0; i--) {
                int furthestJump = Math.min(i + nums[i], nums.length - 1);
                for (int j = i + 1; j <= furthestJump; j++) {
                    if (memo[j] == Index.GOOD) {
                        memo[i] = Index.GOOD;
                        break;
                    }
                }
            }

            return memo[0] == Index.GOOD;
        }

        //bottom up iterative approach
    public static boolean canJump3(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr,-1);
        arr[nums.length-1] = 1;

        for(int i=nums.length-2;i>=0;i--){
            for(int j=i;j<i+nums[i];j++){
                if(arr[j+1]==1)
                {
                    arr[i]=1;
                    break;
                }
            }
        }
        return (arr[0]==1)?true:false;
    }

    public static void main(String[] args) {
        System.out.println(canJump3(new int[]{2,0,0}));
    }
}
