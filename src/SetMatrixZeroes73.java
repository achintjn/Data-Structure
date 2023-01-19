import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void setZeroes(int[][] matrix) {

        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<R;i++){
            for(int j=1;j<C;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<C;i++){
                matrix[0][i]=0;
            }
        }

        if(isCol){
            for(int i=0;i<R;i++){
                matrix[i][0]=0;
            }
        }


    }

    public static void main(String[] args) {
        int [][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
