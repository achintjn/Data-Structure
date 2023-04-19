public class MaxAreadOfIsland695 {
    public static int maxAreaOfIsland(int[][] grid) {

        int area=0;
        int tempArea ;

        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {

                if(grid[row][col]==1)
                {
                    System.out.println(row+","+col);
                    tempArea = 0;
                    tempArea= dfs(grid, row, col, tempArea);
                    area = Math.max(tempArea, area);
                }
                else if(grid[row][col]==0)
                    grid[row][col] = -1;
            }
        }
        return area;

    }

    public static int dfs(int[][] grid2, int r, int c, int count)
    {
        System.out.println("grid2.length:"+grid2.length);
        if(grid2[r][c]==1)
        {
            count++;
            grid2[r][c] = 2;
            if(r>=1)
                count = dfs(grid2, r-1, c, count);
            if(c>=1)
                count = dfs(grid2, r, c-1, count);
            if(r+1<grid2.length)
                count = dfs(grid2, r+1, c, count);
            if(c+1<grid2[0].length)
                count = dfs(grid2, r, c+1, count);
        }

        return count;
    }

    public static int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[r].length;c++){
                if(grid[r][c]==1){
                    max = Math.max(dfs2(grid,r,c),max);
                }
            }
        }
        return max;
    }

    public static int dfs2(int[][] grid, int r, int c){
        int area = 0;
        if(grid[r][c]==1){
            area = area +1;
            grid[r][c]=-1;
            if(r>=1)
                area = area + dfs2(grid,r-1,c);
            if(c>=1)
                area = area + dfs2(grid,r,c-1);
            if(r<grid.length-1)
                area = area + dfs2(grid,r+1,c);
            if(c<grid[0].length-1)
                area = area + dfs2(grid,r,c+1);
        }
        return area;
    }

    //simple dfs
    class Solution {
        int a;
        public int maxAreaOfIsland(int[][] grid) {
            int area = 0;
            for(int r=0;r<grid.length;r++){
                for(int c=0;c<grid[0].length;c++){
                    if(grid[r][c]==1){
                        a=0;
                        dfs(r,c,grid);
                        area = Math.max(a,area);
                    }
                }
            }
            return area;
        }

        public void dfs(int r, int c, int[][] grid){
            if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1 || grid[r][c]!=1)
                return;
            a=a+1;
            grid[r][c]=-1;

            dfs(r-1,c,grid);
            dfs(r,c-1,grid);
            dfs(r+1,c,grid);
            dfs(r,c+1,grid);
        }
    }

    public static void main(String[] args) {

        //int[][] image = {{0,0,0},{0,0,0}};

        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland2(grid));

    }
}