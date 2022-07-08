import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces547 {

    //my solution using bfs
    public static int findCircleNum(int[][] isConnected) {
        int prov=0;
        int n=isConnected.length;
        for(int r=0;r<isConnected.length;r++){
            for(int c=0;c<isConnected[0].length;c++){
                if(isConnected[r][c]==1){
                    prov=prov+bfs(r,c,isConnected);
                }
            }
        }
        return prov;
    }

    public static int bfs(int r, int c, int[][] isConnected){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        while(queue.size()!=0){
            int conn=queue.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[conn][i]==1){
                    isConnected[conn][i] = 2;
                    isConnected[i][conn] = 2;
                    if(conn!=i)
                        queue.add(i);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
        //System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
