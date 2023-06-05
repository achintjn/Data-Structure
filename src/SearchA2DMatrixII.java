public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;

        while(end>=0 && start<matrix[0].length){
            if(matrix[end][start]>target)
                end--;
            else if(target>matrix[end][start])
                start++;
            else
                return true;
        }

        return false;
    }
}
