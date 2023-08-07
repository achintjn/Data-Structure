import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] flight:flights){
            int from = flight[0];
            int to = flight[1];
            adj[from].add(new int[]{to,flight[2]});
        }

        int[] prices = new int[n];
        int[] stops = new int[n];
        int stop  = 0;
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src] = 0;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{src,0});
        while(stop<=k && !que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){
                int[] curr = que.poll();
                for(int[] n0:adj[curr[0]]){
                    int node = n0[0];
                    int node_p = n0[1];

                    if(prices[node]>node_p+curr[1]){
                        prices[node] = node_p+curr[1];
                        que.add(new int[]{node, prices[node]});
                    }
                }
            }
            stop++;
        }

        return prices[dst]==Integer.MAX_VALUE?-1:prices[dst];

    }
}
