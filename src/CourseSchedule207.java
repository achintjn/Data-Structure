import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();


            for(int[] relation:prerequisites){
                if(map.containsKey(relation[1]))
                    map.get(relation[1]).add(relation[0]);
                else
                {
                    List<Integer> list = new LinkedList<>();
                    list.add(relation[0]);
                    map.put(relation[1],list);
                }
            }

            boolean[] path = new boolean[numCourses];
            boolean[] visited = new boolean[numCourses];

            for(int i=0;i<numCourses;i++){
                if(!visited[i])
                    if(isCycle(i,map,path,visited))
                        return false;
            }

            return true;

        }

        public boolean isCycle(int i, HashMap<Integer, List<Integer>> map, boolean[] path,boolean[] visited){

            if(path[i]==true)
                return true;
            if(visited[i])
                return false;

            path[i] = true;
            if(map.containsKey(i)){
                for(int dep:map.get(i))
                    if(isCycle(dep,map,path,visited))
                        return true;
            }
            path[i]=false;
            visited[i]=true;

            return false;

        }
    }
}
