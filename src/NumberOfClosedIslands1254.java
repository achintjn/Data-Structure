import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands1254 {
    public static int closedIsland(int[][] grid) {
        int islands = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(r==5 && c==6)
                    System.out.println(".");

                if(grid[r][c]==0 && r!=0 && c!=0 && r!=grid.length-1 && c!=grid[0].length-1){
                    if(isIsland(r,c,grid)){
                        islands++;
                        System.out.println(r+" "+c);
                    }
                }
            }
        }
        return islands;
    }

    public static boolean isIsland(int r, int c, int[][] grid){
        boolean res = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c});
        int[] dir = {0,1,0,-1,0};
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int a = curr[0];
            int b = curr[1];

            for(int i=0;i<4;i++){
                int r_ = a+dir[i];
                int c_ = b+dir[i+1];

                if(grid[r_][c_]==0){
                    if(r_==0 || c_==0 || r_==grid.length-1 || c_==grid[0].length-1)
                        res=false;
                    else{
                        que.add(new int[]{r_,c_});
                        grid[r_][c_]=-1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        int[][] mat2 = {{1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(mat2));
    }
}
