import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        //list.add(matrix[0][0]);
        int[] dir = {0,1,0,-1,0};
        dfs(0,0,matrix,list,dir,0);
        return list;
    }

    public static void dfs(int r, int c, int[][] matrix, List<Integer> list, int[] dir, int n){
            list.add(matrix[r][c]);
            matrix[r][c]=200;


        boolean change_dir = false;
        if(list.size()==(matrix.length * matrix[0].length))
            return;
        if(r+dir[n]<0 || r+dir[n]>matrix.length-1 || c+dir[n+1]<0 || c+dir[n+1]>matrix[0].length-1 || matrix[r+dir[n]][c+dir[n+1]]==200){
            if(n==3)
                n=0;
            else
                n++;
            change_dir = true;
        }
        dfs(r+dir[n],c+dir[n+1],matrix,list,dir,n);
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
