public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int exp = n*(n+1);
        exp = exp/2;
        int act = 0;
        for(int a:nums)
            act=act+a;

        return exp-act;
    }
}
