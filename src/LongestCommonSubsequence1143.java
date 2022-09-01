public class LongestCommonSubsequence1143 {

    //top-down approach
    public static int longestCommonSubsequence(String text1, String text2) {
        char[]  chr1 = text1.toCharArray();
        char[]  chr2 = text2.toCharArray();
        int[][] dp = new int[chr1.length][chr2.length];
        return common(chr1,chr2,0,0, dp);
    }

    public static int common(char[] chr1, char[] chr2, int i, int j, int[][] dp){
        if(i>chr1.length-1 || j>chr2.length-1)
            return 0;
        else if(dp[i][j]!=0)
            return dp[i][j];
        else if(chr1[i]==chr2[j]){
            dp[i][j]=1+common(chr1, chr2, 1+i,1+j,dp);
            return dp[i][j];
        }
        else{
            dp[i][j]= Math.max(common(chr1, chr2,i,1+j,dp),common(chr1, chr2, 1+i,j,dp));
            return dp[i][j];
        }


    }

    //bottom up
    public static int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[i].length-2;j>=0;j--){
                if(ch1[i]==ch2[j])
                    dp[i][j]=1+dp[i+1][j+1];
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence2("abcde","ace"));
    }
}
