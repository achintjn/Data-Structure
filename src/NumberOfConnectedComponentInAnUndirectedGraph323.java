import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfConnectedComponentInAnUndirectedGraph323 {
    public int countComponents(int n, int[][] edges) {

        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList();
        }

        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] visited = new int[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,adj,visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i, ArrayList<Integer>[] adj, int[] visited){
        if(visited[i]!=0)
            return;
        visited[i]++;
        for(int node:adj[i])
            dfs(node,adj,visited);
    }

    //union and find
    int[] rank;
    int[] parent;
    public int countComponents2(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];

        Arrays.fill(rank,1);

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }

        int graphs=0;
        boolean[] g = new boolean[n];
        for(int i=0;i<n;i++){
            int p = find(i);
            if(!g[p]){
                g[p] = true;
                graphs++;
            }
        }
        return graphs;
    }

    public int find(int x){
        if(parent[x]==x)
            return x;
        return find(parent[x]);
    }

    public void union(int x, int y){
        int rx = rank[x];
        int ry = rank[y];

        int px = find(x);
        int py = find(y);

        if(rx>ry)
            parent[py] = px;
        else if(ry>rx)
            parent[px] = py;
        else if(rx==ry){
            rank[x]++;
            parent[py] = px;
        }
    }
}
