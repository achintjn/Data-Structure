import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200 {
    public static int numIslands(char[][] grid) {
        int islands=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1'){
                    islands++;
                    bfs(r,c,grid);
                }
            }
        }
        return islands;
    }

    public static void bfs(int r, int c, char[][] grid){
        int [] side = new int[]{1,0,-1,0,1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        while(queue.size()!=0){
            int[] arr=queue.poll();
            int row=arr[0];
            int col=arr[1];
            for(int i=0;i<4;i++){
                int a = side[i];
                int b = side[i+1];

                if(row+a<0 || row+a>grid.length-1 || col+b<0 || col+b>grid[0].length-1 || grid[row+a][col+b]!='1')
                    continue;
                else{
                    grid[row+a][col+b] = '2';
                    queue.add(new int[]{row+a,col+b});
                }
            }
        }
    }

    public static int numIslands2(char[][] grid) {
        int islands=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1'){
                    islands++;
                    dfs(r,c,grid);
                }
            }
        }
        return islands;
    }

    public static void dfs(int r, int c, char[][] grid){
        if(r<0 || r>grid.length-1 || c<0 || c>grid[0].length-1 || grid[r][c]!='1')
            return ;
        grid[r][c]='2';

        dfs(r+1,c,grid);
        dfs(r,c+1,grid);
        dfs(r-1,c,grid);
        dfs(r,c-1,grid);
    }

    public static void main(String[] args) {
        System.out.println(numIslands2(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
