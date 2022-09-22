import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow417 {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] dp = new int[heights.length][heights[0].length];

        for(int c=0;c<heights[0].length;c++){
            dfs(0,c,heights, dp, false, heights[0][c]);
        }
        for(int r=0;r<heights.length;r++){
            dfs(r,0,heights, dp, false,heights[r][0]);
        }
        int[][] dp_atl = new int[heights.length][heights[0].length];
        for(int c=0;c<heights[0].length;c++){
            dfs(heights.length-1,c,heights, dp_atl, true,heights[heights.length-1][c]);
        }
        for(int r=0;r<heights.length;r++){
            dfs(r,heights[r].length-1,heights, dp_atl, true,heights[r][heights[r].length-1]);
        }

        for(int r=0;r<dp.length;r++){
            for(int c=0;c<dp[0].length;c++){
                if(dp[r][c]==1 && dp_atl[r][c]==1){
                    List<Integer> inlist = new ArrayList<>();
                    inlist.add(r);
                    inlist.add(c);
                    list.add(inlist);
                }

            }
        }
        return list;
    }

    public static void dfs(int r, int c, int[][] heights, int[][] dp, boolean isAtlantic, int prev){
        if(dp[r][c]!=1)
            dp[r][c]++;
        int[] dir = new int[]{-1,0,1,0,-1};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c});
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int _r = arr[0];
            int _c = arr[1];
            for(int i=0;i<4;i++){
                int r1=_r+dir[i];
                int c1 = _c+dir[i+1];
                if(r1<0 || r1>heights.length-1 || c1<0 || c1>heights[0].length-1 || heights[_r][_c]>heights[r1][c1] || dp[r1][c1]!=0)
                    continue;
                dp[r1][c1]++;
                que.add(new int[]{r1,c1});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
}
