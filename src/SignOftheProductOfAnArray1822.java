public class SignOftheProductOfAnArray1822 {
        public int arraySign(int[] nums) {
            int neg = 0;

            for(int n:nums){
                if(n==0)
                    return 0;
                if(n<0)
                    neg++;
            }

            if(neg%2==0)
                return 1;
            return -1;

        }
}
