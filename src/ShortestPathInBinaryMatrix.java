import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    //my impl
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid[0].length-1][grid.length-1]!=0)
            return -1;

        int [] dir = new int[]{-1,-1,1,1,-1,0,1,0,-1};
        Queue<int[]> que =  new LinkedList<>();
        que.add(new int[]{0,0});
        grid[0][0]=1;
        while(!(que.isEmpty())){
            int [] rc = que.poll();
            int r = rc[0];
            int c = rc[1];
            int distance = grid[r][c];

            for(int i=0;i<8;i++){
                int a = dir[i];
                int b = dir[i+1];

                if(r+a<0 || r+a>grid[0].length-1 || c+b<0 || c+b>grid.length-1 || grid[r+a][c+b]!=0)
                    continue;
                grid[r+a][c+b]=distance+1;
                que.add(new int[]{r+a,c+b});
            }
        }

        if(grid[grid[0].length-1][grid.length-1]==0)
            return -1;
        else
            return grid[grid[0].length-1][grid.length-1];

    }

    public static int shortestPathBinaryMatrix2(int[][] grid) {
        if(grid[0][0]!=0)
            return -1;
        int[][] distance = new int[grid.length][grid[0].length];

                bfs(0,0, grid,distance);


        if(distance[grid.length-1][grid[0].length-1]==0)
            return -1;
        else
            return distance[grid.length-1][grid[0].length-1];

    }

    public static void bfs(int r, int c, int[][] grid,int[][] distance){
        distance[0][0] =1;
        int[][] dir = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c});
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int r1 = arr[0];
            int c1 = arr[1];
            for(int i=0;i<dir.length;i++){
                int a = r1+dir[i][0];
                int b = c1+dir[i][1];
                if(a<0 || b<0 || a>grid.length-1 || b>grid.length-1 || grid[a][b]!=0)
                    continue;
                else{
                    if(distance[a][b]==0 || distance[a][b]>1+distance[r1][c1]) {
                        distance[a][b]=1+distance[r1][c1];
                        que.add(new int[]{a,b});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix2(new int[][]{{0,1},{1,0}}));
    }
}
