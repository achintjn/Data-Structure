import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumCostToConnectAllPoint1584 {

    //MST kruskal's
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> map = new ArrayList<>();
        int[] parent = new int[points.length+1];
        int[] rank = new int[points.length+1];
        Arrays.fill(rank,1);

        for(int i=0;i<parent.length;i++)
            parent[i]=i;

        for(int i=0;i<points.length;i++){
            for(int j=1;j<points.length;j++){
                int len = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                map.add(new int[]{len,i,j});
            }
        }
        Collections.sort(map, (a, b)->a[0]-b[0]);

        int count=0;
        int edgeUsed = 0;

        for(int[] point:map){
            if(edgeUsed==points.length-1)
                break;
            int dist = point[0];
            if(union(point[1], point[2], rank, parent)){
                count = count+dist;
                edgeUsed++;
            }
        }
        return count;
    }

    public int find(int x, int[] parent){
        if(parent[x]==x)
            return x;
        return find(parent[x],parent);
    }

    public boolean union(int x, int y, int[] rank, int[] parent){
        int xp = find(x, parent);
        int yp = find(y, parent);

        if(xp==yp)
            return false;

        int xr = rank[x];
        int yr = rank[y];

        if(xr>yr){
            parent[yp] = xp;
        }else if(xr<yr)
            parent[xp] = yp;
        else if(xr==yr){
            parent[yp] = xp;
            rank[xr]++;
        }
        return true;
    }
}
