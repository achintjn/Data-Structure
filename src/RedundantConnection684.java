import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RedundantConnection684 {

        Set<Integer> seen = new HashSet();
        int MAX_EDGE_VAL = 1000;

        public int[] findRedundantConnection(int[][] edges) {
            ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
            for (int i = 0; i <= MAX_EDGE_VAL; i++) {
                graph[i] = new ArrayList();
            }

            for (int[] edge: edges) {
                seen.clear();
                if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                        dfs(graph, edge[0], edge[1])) {
                    return edge;
                }
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            throw new AssertionError();
        }
        public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
            if (!seen.contains(source)) {
                seen.add(source);
                if (source == target) return true;
                for (int nei: graph[source]) {
                    if (dfs(graph, nei, target)) return true;
                }
            }
            return false;
        }


    public int[] findRedundantConnection2(int[][] edges) {
        int[][] adj = new int[edges.length+1][edges.length+1];
        Set<Integer> set = new HashSet<>();

        for(int[] edge:edges){
            set.clear();
            int from  = edge[0];
            int to  = edge[1];
            adj[from][to] = 1;
            adj[to][from] = 1;
            set.add(from);
            if(dfs(adj,set, from))
                return edge;
        }
        return new int[0];
    }

    public boolean dfs(int[][] adj, Set<Integer> set, int from){


        for(int i=1;i<adj[0].length;i++){
            if(adj[from][i]==1){
                adj[from][i]=0;
                adj[i][from]=0;
                if(set.contains(i))
                    return true;
                set.add(i);
                if(dfs(adj,set, i))
                    return true;
                adj[from][i]=1;
                adj[i][from]=1;
                set.remove(i);
            }
        }
        return false;
    }

    // disjoint set union
    public int[] findRedundantConnection3(int[][] edges) {
        int[] parent = new int[1001];
        int[] rank = new int[1001];
        Arrays.fill(rank,1);

        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        for(int[] curr:edges){
            if(!union(curr[0],curr[1],rank,parent))
                return curr;
        }

        return new int[0];
    }

    public int find(int i,int[] parent){
        if(parent[i]==i)
            return i;
        return find(parent[i],parent);
    }

    public boolean union(int x, int y, int[] rank,int[] parent){
        int xp = find(x,parent);
        int yp = find(y,parent);
        if(xp==yp)
            return false;

        int xr = rank[xp];
        int yr = rank[yp];

        if(xr>yr){
            parent[yp]=xp;
            //rank[xr] += rank[yr];
        }else if(yr>xr){
            parent[xp]=yp;
            //rank[yr] += rank[xr];
        }else if(xr==yr){
            parent[yp]=xp;
            rank[xr] += rank[yr];
        }
        return true;
    }
}
