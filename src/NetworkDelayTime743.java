import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] adj = new ArrayList[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k]=0;

        for(int i=0;i<=n;i++)
            adj[i]=new ArrayList<>();

        for(int[] time:times){
            int[] temp = new int[]{time[1],time[2]};
            adj[time[0]].add(temp);
        }

        int [] seen = new int[n+1];
        bfs(adj,k, seen,distance);

        int cnt=1;
        int res = 0;
        for(int i=1;i<=n;i++){
            res = Math.max(res,distance[i]);
        }

        if(res!=Integer.MAX_VALUE)
            return res;
        return -1;
    }
    public void bfs(ArrayList<int[]>[] adj, int k, int[] seen, int[] distance){

        Queue<int[]> que =  new PriorityQueue<>((a, b)->a[1]-b[1]);
        que.add(new int[]{k,0});

        while(!que.isEmpty()){
            int[] node = que.poll();
            int curr_distance = distance[node[0]];
            for(int[] n:adj[node[0]]){
                if(distance[n[0]]>curr_distance+n[1]){
                    distance[n[0]] = curr_distance+n[1];
                    que.add(n);
                }
            }

        }
    }
}
