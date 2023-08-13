public class LongestPalindromicSubsequence516 {
    public int longestPalindromeSubseq(String s) {
        char[] chr= s.toCharArray();
        int[][] dp = new int[chr.length][chr.length];
        return longest(0,chr.length-1,chr,dp);

    }

    public int longest(int left, int right, char[] chr,int[][] dp){
        if(left>right)
            return 0;

        if(dp[left][right]!=0)
            return dp[left][right];

        if(left==right)
            return 1;

        if(chr[left]==chr[right])
            dp[left][right] = longest(left+1,right-1,chr,dp) +2;
        else
            dp[left][right] = Math.max(longest(left+1,right,chr,dp),longest(left,right-1,chr,dp));

        return dp[left][right];
    }
}
