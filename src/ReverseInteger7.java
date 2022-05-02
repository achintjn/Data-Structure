public class ReverseInteger7 {

    public int reverse(int x) {
        //int final;
        String s ="";
        String s1="";
        while(x!=1){
            Integer num = x%10;
            if (num!=0)
                 s1 = num.toString();
            s = s+s1;
            x = (x -num)/10;
        }

        return Integer.parseInt(s);

    }

    public static void main(String[] args) {

    }
}
