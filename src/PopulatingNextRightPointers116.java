import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointers116 {

    public static Node connect(Node root) {

        List<Node> list = new LinkedList<>();
        list.add(root);

        Node tempN = null;

        while(!list.isEmpty()){

            tempN = ((LinkedList<Node>) list).poll();

            if(tempN.left!=null){
                if(tempN.right!=null) {
                    tempN.left.next = tempN.right;
                    if (tempN.next != null)
                        tempN.right.next = tempN.next.left;
                }
            }

            if(tempN.left!=null)
                list.add(tempN.left);
            if(tempN.right!=null)
                list.add(tempN.right);

        }

        return root;

    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node2 = new Node(2,node4,node5,null);
        Node node3 = new Node(3,node6, node7, null);
        Node node1 = new Node(1,node2, node3, null);

        connect(node1);

    }
}
