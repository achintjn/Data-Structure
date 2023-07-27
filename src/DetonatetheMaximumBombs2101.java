import java.util.ArrayList;

public class DetonatetheMaximumBombs2101 {
    public int maximumDetonation(int[][] bombs) {
        ArrayList<Integer>[] adj = new ArrayList[bombs.length+1];
        for(int i=0;i<=bombs.length;i++){
            adj[i] = new ArrayList<>();
        }
        int[] indegree = new int[bombs.length+1];
        for(int i=0;i<bombs.length;i++){
            for(int j=0;j<bombs.length;j++){
                if(i==j)
                    continue;
                long x1 = bombs[i][0] - bombs[j][0];
                long y1 = bombs[i][1] - bombs[j][1];
                long dist = (long)x1*x1+(long)y1*y1;

                long r = bombs[i][2] * bombs[i][2];
                if((long)bombs[i][2] * bombs[i][2]>=(long)x1*x1+(long)y1*y1)
                    adj[i].add(j);
            }
        }


        int[] visited = new int[bombs.length+1];
        int[] seen = new int[bombs.length+1];
        int res =0;
        for(int i=0;i<bombs.length;i++){
            int cnt = dfs(new int[bombs.length+1],i,0,adj);
            visited[i] = cnt;
            res = Math.max(cnt,res);
        }
        return res;
    }

    public int dfs( int[] seen, int i, int c,ArrayList<Integer>[] adj){
        if(seen[i]!=0)
            return 0;
        seen[i]++;
        c++;
        for(int a:adj[i]){
            c = c+dfs(seen,a,0,adj);
        }
        //seen[i]--;
        return c;
    }
}
