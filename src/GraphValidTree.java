import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GraphValidTree {
    Set<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length<n-1)
            return false;
        ArrayList<Integer>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge:edges){
            seen.clear();
            if(!adj[edge[0]].isEmpty() && !adj[edge[0]].isEmpty() && dfs(edge[0],edge[1],adj))
                return false;

            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return true;
    }

    public boolean dfs(int source, int target, ArrayList<Integer>[] adj){
        if(!seen.contains(source)){
            seen.add(source);
            if(source==target)
                return true;
            for(int a:adj[source]){
                if(dfs(a,target,adj))
                    return true;
            }
        }
        return false;
    }
}
