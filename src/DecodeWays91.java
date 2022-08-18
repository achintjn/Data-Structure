import java.util.Arrays;

public class DecodeWays91 {
    public static int numDecodings(String s) {
        char[] chr = s.toCharArray();
        if(chr[0]=='0')
            return 0;
        int[] arr = new int[chr.length];
        Arrays.fill(arr,-1);
        return countAt(0,s,chr,arr);
    }

    public static int countAt(int i, String s, char[] chr, int[] arr){
        if(i>chr.length-1)
            return 1;
        if(arr[i]!=-1)
            return arr[i];
        if(chr[i]=='0'){
            arr[i]=0;
            return 0;
        }


        int b=0;
        int a = countAt(i+1,s,chr,arr);
        if(s.charAt(i)!='0' && i+2<=chr.length && Integer.parseInt(s.substring(i,i+2))<=26)
            b = countAt(i+2,s,chr,arr);
        arr[i]=a+b;
        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("2326"));
    }
}
