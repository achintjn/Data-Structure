import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges994 {
    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        boolean hasOne = false;
        for(int r=0;r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                if(grid[r][c]==2)
                    queue.add(new int[]{r,c});
                else if(grid[r][c]==1)
                    hasOne = true;
            }
        }


        if( (queue.isEmpty() && !hasOne) || (!queue.isEmpty() && !hasOne) )
            return 0;
        if(queue.isEmpty() && hasOne)
            return -1;


        int[][] dist = {{0,1},{1,0},{0,-1},{-1,0}};

        int minutes = -1;

        while(!queue.isEmpty()){
            minutes = minutes +1;
            int n = queue.size();
            for(int i=0;i<n;i++){
                int [] rc = queue.poll();
                for(int j=0;j<4;j++){
                    int r = rc[0] + dist[j][0];
                    int c = rc[1] + dist[j][1];

                    if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!=1)
                        continue;
                    else{
                        grid[r][c] = 2;
                        queue.add(new int[]{r,c});
                    }

                }
            }
        }

        for(int r=0;r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                if(grid[r][c]==1)
                    return -1;
            }
        }

        return minutes;

    }

    public static void main(String[] args) {
        int[][] image = {{2,1,1},{1,1,1},{0,1,2}};

        System.out.println(orangesRotting(image));
    }
}
