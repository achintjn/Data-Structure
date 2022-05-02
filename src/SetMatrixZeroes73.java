import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void setZeroes(int[][] matrix) {

        for(int r=0; r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c]==0){
                    matrix[0][c]=0;
                    matrix[r][0]=0;
                }
            }
        }

        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][0]==0 || matrix[0][c]==0)
                    matrix[r][c]=0;
            }
        }


    }

    public static void main(String[] args) {
        int [][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
