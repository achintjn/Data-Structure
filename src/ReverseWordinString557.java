import java.util.ArrayList;

public class ReverseWordinString557 {

    public static ArrayList<String> customSplit(String s){
        ArrayList<String> arrS = new ArrayList<String>();
        int point = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)==' '){
                arrS.add(s.substring(point,i));
                point = i+1;
            }
            if(i==s.length()-1){
                arrS.add(s.substring(point,i+1));
            }
        }
        return arrS;
    }

    public static String reverse(String s){
        int start = 0;
        int end = s.length()-1;

        char[] chr = s.toCharArray();

        while(start<end){
            char temp = chr[start];
            chr[start] = chr[end];
            chr[end] = temp;
            start++;
            end--;
        }

        s=String.valueOf(chr);
        return s;
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ArrayList arl = customSplit(s);
        /*System.out.println(arl);
        s = reverse(s);
        System.out.println(s);*/

        ArrayList<String> arrS = customSplit(s);
        String finalS = new String("");
        for(String str:arrS){
            finalS = finalS.concat(reverse(str)+" ");
        }
        System.out.println(finalS);
    }
}
