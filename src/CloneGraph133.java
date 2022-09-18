import java.util.*;
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph133 {
    //BFS
    public GraphNode cloneGraph(GraphNode node) {
        if(node==null)
            return null;
        Queue<GraphNode> que = new LinkedList<>();
        Map<GraphNode, GraphNode> map = new HashMap<>();
        que.add(node);

        while(!que.isEmpty()){
            GraphNode curr = que.poll();
            if(!map.containsKey(curr))
                map.put(curr, new GraphNode(curr.val, new ArrayList()));
            for(GraphNode n:curr.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new GraphNode(n.val, new ArrayList()));
                    que.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));

            }
        }
        return map.get(node);
    }

    //DFS
}
