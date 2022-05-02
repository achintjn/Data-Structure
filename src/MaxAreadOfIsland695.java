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

    public static void main(String[] args) {

        //int[][] image = {{0,0,0},{0,0,0}};

        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));

    }
}