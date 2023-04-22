import java.util.ArrayList;

public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        ArrayList<Integer> dig = new ArrayList<>();
        int carry = 1;

        for(int i=digits.length-1;i>=0;i--){
            int a = digits[i]+carry;
            carry = 0;
            if(a>=10){
                int x = a;
                a = a%10;
                carry=(x-a)/10;
            }
            dig.add(a);
        }
        if(carry==1)
            dig.add(carry);
        int s = dig.size();
        int[] res = new int[s];

        for (int i = dig.size()-1; i >= 0; i--)
            res[s-i-1] = dig.get(i);

        return res;
    }
}
