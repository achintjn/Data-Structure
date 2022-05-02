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

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,2,8,0,3,7};

        System.out.println(rob(arr));
    }
}
