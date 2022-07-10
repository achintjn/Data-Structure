import java.util.LinkedList;
import java.util.Queue;

public class PopulatingEachNextRightPointerInEachNodeII {

    public static Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> que = new LinkedList<>();
        Node move = root;
        que.add(move);
        while(!(que.isEmpty())){
            int size = que.size();
            for(int i=0;i<size;i++){
                move = que.poll();
                if(i==size-1)
                    move.next = null;
                else{
                    move.next = que.peek();
                }

                if(move.left!=null){
                    que.add(move.left);
                }
                if(move.right!=null){
                    que.add(move.right);
                }


            }

        }
        return root;
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node2 = new Node(2,node4,node5,null);
        Node node3 = new Node(3,null, node7, null);
        Node node1 = new Node(1,node2, node3, null);

        connect(node1);
    }
}
