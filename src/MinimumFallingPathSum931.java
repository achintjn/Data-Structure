import java.util.Arrays;

public class MinimumFallingPathSum931 {

    // Top Down Dynamic Programming
    public static int minFallingPathSum(int[][] matrix) {
        Integer[][] mat = new Integer[matrix.length][matrix[0].length];
        //Arrays.fill(mat, null);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
             int temp = minFall(0,i,matrix,mat);
             min = Math.min(min,temp);
        }

        return min;

    }

    public static int minFall(int r, int c, int[][] matrix, Integer[][] mat){
        if(r>=matrix.length)
            return 0;
        if(c>=matrix[0].length || c<0)
            return Integer.MAX_VALUE;
        if(mat[r][c]!=null)
            return mat[r][c];
        int val1= minFall(r+1,c,matrix,mat);
        int val2= minFall(r+1,c-1,matrix,mat);
        int val3= minFall(r+1,c+1,matrix,mat);

        int val4 = Math.min(val1, Math.min(val2,val3));
        mat[r][c] = matrix[r][c]+val4;
        return mat[r][c];
    }

    //Bottom-Up Dynamic Programming (Tabulation)
    public static  int minFallingPathSum2(int[][] matrix) {
        int dp[][] = new int[matrix.length + 1][matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    dp[row][col] =
                            Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    dp[row][col] =
                            Math.min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row + 1][col],
                            Math.min(dp[row + 1][col + 1], dp[row + 1][col - 1])) + matrix[row][col];
                }
            }
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[0][startCol]);
        }
        return minFallingSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        System.out.println(minFallingPathSum2(matrix));
    }
}
