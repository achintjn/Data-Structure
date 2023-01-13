import java.util.PriorityQueue;

public class KClosestPointsTOOrigin973 {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> (a[0]*a[0]+a[1]*a[1]) -  (b[0]*b[0]+b[1]*b[1]));

            for(int[] p:points){
                pq.offer(p);
            }

            int[][] arr = new int[k][2];
            int i=k;
            while(k>0){
                arr[i-k] = pq.poll();
                k--;
            }
            return arr;
        }


    }
}
