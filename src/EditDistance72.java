public class EditDistance72 {
    public static int minDistance(String word1, String word2) {
            char[] w1 = word1.toCharArray();
            char[] w2 = word2.toCharArray();
            int[][] dp = new int[word1.length()+1][word2.length()+1];
            // init boundaries
            for (int i = 0; i < w1.length + 1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < w2.length + 1; j++) {
                dp[0][j] = j;
            }
            for(int i=1; i<=w1.length;i++){
                for(int j=1; j<=w2.length;j++){
                    if(w1[i-1]==w2[j-1])
                        dp[i][j]=dp[i-1][j-1];
                    else
                        dp[i][j] = Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }

            return dp[word1.length()][word2.length()];
        }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
}
