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

    public static int orangesRotting2(int[][] grid) {
        int minutes = 0;
        boolean hasOne = false;
        Queue<int[]> q = new LinkedList<>();
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==2)
                    q.add(new int[]{r,c});
                else if(grid[r][c]==1)
                    hasOne = true;

            }
        }
        if( (q.isEmpty() && !hasOne) || (!q.isEmpty() && !hasOne) )
            return 0;
        if(q.isEmpty() && hasOne)
            return -1;
        int [] dir = {0,1,0,-1,0};

        while(!q.isEmpty()){
            int size = q.size();
            minutes = minutes +1;
            for(int j=0;j<size;j++){
                int[] get = q.poll();
                int row1 = get[0];
                int col1 = get[1];
                for(int i=0;i<4;i++){
                    int r = row1 + dir[i];
                    int c = col1 + dir[i+1];

                    if(r<0 || r>grid.length-1 || c<0 || c>grid[0].length-1 || grid[r][c]==2 || grid[r][c]==0) continue;
                    grid[r][c]=grid[row1][col1];

                    q.add(new int[]{r,c});
                }
            }

        }

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1)
                    return -1;
            }
        }
        return minutes-1;
    }

    public static void main(String[] args) {
        int[][] image = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting2(image));
    }

        //fastest
        public int orangesRotting3(int[][] grid) {
            int time=0;
            int[] dir = {1,0,-1,0,1};
            Queue<int[]> que = new LinkedList<>();
            for(int r=0;r<grid.length;r++){
                for(int c=0;c<grid[0].length;c++){
                    if(grid[r][c]==2)
                        que.add(new int[]{r,c});
                }
            }
            while(!que.isEmpty()){

                int size = que.size();
                for(int i=0;i<size;i++){
                    int[] curr = que.poll();
                    int a = curr[0];
                    int b = curr[1];
                    for(int j=0;j<4;j++){
                        int _r = a+dir[j];
                        int _c = b+dir[j+1];

                        if(_r<0 || _c<0 || _c>grid[0].length-1 || _r>grid.length-1 || grid[_r][_c]!=1)
                            continue;
                        grid[_r][_c]=3;
                        que.add(new int[]{_r,_c});
                    }
                }
                time++;
            }
            if(time>0)
                time--;
            for(int r=0;r<grid.length;r++){
                for(int c=0;c<grid[0].length;c++){
                    if(grid[r][c]==1)
                        time=-1;
                }
            }
            return time;
        }



}
