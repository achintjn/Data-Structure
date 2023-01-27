import java.util.ArrayList;

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
}
