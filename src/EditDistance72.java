public class EditDistance72 {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();

        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[i].length-2;j>=0;j--){
                if(ch1[i]==ch2[j])
                    dp[i][j]=1+dp[i+1][j+1];
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }

        int change=0;
        int r=dp.length-2,c=dp[0].length-2;
        int count=0;
        for(int i=dp[0].length-2;i>=0;i--){
            for(int j=dp.length-2;j>=0;j--){
                if(dp[j][i]!=change && dp[j][i]>change){
                    count=count+Math.max(r-j,c-i);
                    change=dp[j][i];
                    r=j;
                    c=i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
}
