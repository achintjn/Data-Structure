public class PalindromePermutation266 {
    public boolean canPermutePalindrome(String s) {
        char[] chr = s.toCharArray();
        int[] c = new int[26];

        for(char a:chr){
            c[a-'a']++;
        }

        int allow = 0;
        for(int a:c){
            if(a%2!=0)
                allow++;
        }

        return allow<2;
    }
}
