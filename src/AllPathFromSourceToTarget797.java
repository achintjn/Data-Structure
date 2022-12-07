import java.util.LinkedList;
import java.util.List;

public class AllPathFromSourceToTarget797 {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int items = graph.length;

        LinkedList<List<Integer>> list= new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(0);
        dfs(0,graph, list,list2);

        return list;
    }

    public static void dfs(int row, int[][] graph, LinkedList<List<Integer>> list,LinkedList<Integer> list2){

        if(row==graph.length-1){
            list.add(new LinkedList<>(list2));
            return;
        }

        for(int i=0;i<graph[row].length;i++){
            list2.add(graph[row][i]);
            dfs(graph[row][i],graph,list,list2);
            list2.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<graph[0].length;i++){
            List<Integer> list = new LinkedList<>();
            list.add(0);
            dfs(0,i,graph, list, res);
        }
        return res;
    }

    public void dfs(int r, int c, int[][] graph, List<Integer> list, List<List<Integer>> res){
        int val = graph[r][c];
        list.add(val);
        if(val==graph.length-1){
            res.add(new LinkedList(list));
            return;
        }

        for(int i=0;i<graph[val].length;i++){
            dfs(val,i,graph, list, res);
            list.remove(list.size()-1);
        }
    }
}
