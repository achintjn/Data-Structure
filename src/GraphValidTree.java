import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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



    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen2 = new HashSet<>();


    public boolean validTree2(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return dfs2(0, -1) && seen2.size() == n;
    }

    public boolean dfs2(int node, int parent) {
        if (seen2.contains(node)) return false;
        seen2.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            if (parent != neighbour) {
                boolean result = dfs2(neighbour, node);
                if (!result) return false;
            }
        }
        return true;
    }
}
