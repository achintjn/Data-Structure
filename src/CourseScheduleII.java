import java.util.HashMap;
import java.util.*;

public class CourseScheduleII {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int[] incoming = new int[numCourses];

            for(int[] conn: prerequisites){
                List<Integer> list= map.getOrDefault(conn[1],new ArrayList<>());
                list.add(conn[0]);
                map.put(conn[1],list);
                incoming[conn[0]]++;
            }

            LinkedList<Integer> que = new LinkedList<>();

            for(int i=0;i<numCourses;i++){
                if(incoming[i]==0)
                    que.add(i);
            }

            int i=0;
            int[] res = new int[numCourses];
            while(!que.isEmpty()){
                int node = que.poll();
                if(map.containsKey(node)){
                    for(int neighbors:map.get(node)){
                        incoming[neighbors]--;
                        if(incoming[neighbors]==0)
                            que.add(neighbors);
                    }
                }
                res[i++]=node;
            }

            if(i==numCourses)
                return res;
            return new int[0];
        }
    }


    //faster soln
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int[] p:prerequisites){
            if(adj[p[1]]==null)
                adj[p[1]] = new ArrayList<>();
            adj[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        int[] res = new int[numCourses];

        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                que.add(i);
        }
        int j=0;
        while(!que.isEmpty()){
            int a = que.poll();
            res[j] =a;
            j++;
            if(adj[a]!=null){
                for(int i:adj[a]){
                    indegree[i]--;
                    if(indegree[i]==0)
                        que.add(i);
                }
            }
        }

        return j==numCourses?res:new int[0];
    }
}
