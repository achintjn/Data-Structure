public class SearchA2DMatrix74 {
    //my solution
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix[0].length;
        int colLen = matrix.length;

        int start = 0;
        int end = colLen-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid][0]==target)
                return true;
            if(target>matrix[mid][0])
                start=mid+1;
            else
                end = mid-1;
        }

        if(rowLen==1)
            return false;

        int row ;
        if(start==colLen && target>matrix[start-1][0])
            row = start-1;
        else if(start!=colLen && target>matrix[start][0])
            row = start;
        else if(target<matrix[start][0] && start!=0)
            row = start-1;
        else
            return false;

        start = 0;
        end = rowLen-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target==matrix[row][mid])
                return true;
            if(target>matrix[row][mid])
                start=mid+1;
            else if(target<matrix[row][mid])
                end = mid-1;
        }

        return false;
    }

    //my solution
    public static boolean searchMatrix2(int[][] matrix, int target) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int len = rowLen * colLen-1;

        int start = 0;
        int end = len;

        while(start<=end){
            int mid = start + (end-start)/2;
            int r = (mid)/colLen;
            int c = mid%colLen;

            if(matrix[r][c]==target)
                return true;
            if(target>matrix[r][c])
                start = mid+1;
            if(target<matrix[r][c])
                end = mid-1;

        }

        return false;
    }

    //solution from Leetcode
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }

    //my solution from June 5 2023
    public boolean searchMatrix2023(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = (r*c)-1;

        while(start<=end){
            int i = start + (end-start)/2;
            int r1 = i/c;
            int c1 = (i%c) ;
            if(matrix[r1][c1]==target)
                return true;
            if(matrix[r1][c1]>target)
                end = i-1;
            else
                start = i+1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1}};
        System.out.println(searchMatrix2(mat,2));
    }
}
