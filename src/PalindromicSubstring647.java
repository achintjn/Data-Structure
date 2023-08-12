public class PalindromicSubstring647 {
    public int countSubstrings(String s) {
        char[] chr = s.toCharArray();
        int count = 0;
        for(int i=0;i<chr.length;i++){
            count += checkAndCount(chr,i,i,0) + checkAndCount(chr,i,i+1,0);
        }
        return count;
    }

    public int checkAndCount(char[] chr, int left, int right, int cnt){
        while(left>=0 && right<chr.length && chr[left]==chr[right]){
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
