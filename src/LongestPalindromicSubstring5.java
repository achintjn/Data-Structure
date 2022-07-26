public class LongestPalindromicSubstring5 {
    public static String longestPalindrome(String s) {
        if(s.length()==1)
            return s;
        int left=0,right=1;
        String max="";
        char[] s1 = s.toCharArray();
        for(int i=1;i<s1.length;i++){
            if(s1[left]==s1[right]){
                String temp_str = checkLong(left,right,s1,s);
                if(temp_str.length()>max.length())
                    max=temp_str;
            }
            left++;
            right++;
        }
        left=0;
        right=0;
        for(int i=0;i<s1.length;i++){
            if(s1[left]==s1[right]){
                String temp_str = checkLong(left,right,s1,s);
                if(temp_str.length()>max.length())
                    max=temp_str;
            }
            left++;
            right++;
        }
        return max;
    }

    public static String checkLong(int left, int right, char[] s1, String s){
        if(left<0 || right>s1.length-1 || s1[left]!=s1[right])
            return s.substring(left+1,right);
        else
            return checkLong(left-1,right+1,s1,s);
    }

    public static void main(String[] args) {
        System.out.println("ok: "+longestPalindrome("ac"));
    }
}
