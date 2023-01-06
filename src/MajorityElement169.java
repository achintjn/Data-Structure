public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[0];

        for(int i:nums){
            if(res!=i){
                count--;
            }
            else
                count++;
            if(count<0){
                res = i;
                count=1;
            }

        }

        return res;

    }
}
