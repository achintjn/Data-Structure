import java.util.HashSet;

public class HappyNumber202 {
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            if(n==1)
                return true;
            while(n!=1){
                int num = squareAndRet(n);
                if(set.contains(num))
                    return false;
                set.add(num);
                n=num;
            }
            return true;
        }

        public int squareAndRet(int n){
            int sum = 0;

            while(n>1){
                int i = n%10;
                sum = sum + i*i;
                n=n/10;
                if(n==1)
                    sum = sum+1;
            }
            return sum;
        }
    }
}
