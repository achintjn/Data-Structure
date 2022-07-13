import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    //my impl
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid[0].length-1][grid.length-1]!=0)
            return -1;

        int [] dir = new int[]{-1,-1,1,1,-1,0,1,0,-1};
        Queue<int[]> que =  new LinkedList<>();
        que.add(new int[]{0,0});grid[0][0]=1;
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

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
}
