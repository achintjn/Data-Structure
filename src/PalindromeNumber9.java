public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))
            return false;
        int y = 0;
        int temp = x;
        while(x>y){
            int z = x%10;
            temp = x;
            x = (x-z)/10;
            y = (y*10)+z;
        }

        if(x==y || y==temp)
            return true;
        return false;
    }
}
