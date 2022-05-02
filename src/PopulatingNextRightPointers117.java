import java.util.LinkedList;
import java.util.Queue;



public class PopulatingNextRightPointers117 {

    public static Node connect(Node root) {

        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        Node tempN = null;

        while(!queue.isEmpty()){

            tempN = queue.poll();

            if(tempN.left!=null){
                if(tempN.right!=null)
                    tempN.left.next = tempN.right;
                else
                    tempN.left.next = getThatNode(tempN);
            }


            if(tempN.right!=null){
                tempN.right.next = getThatNode(tempN);
            }

            if(tempN.left!=null)
                queue.add(tempN.left);
            if(tempN.right!=null)
                queue.add(tempN.right);

        }
        return root;
    }

    public static Node getThatNode(Node node){
        while(node.next!=null){
            if(node.next.left!=null)
                return node.next.left;
            else if(node.next.right!=null)
                return node.next.right;

            node = node.next;
        }

        return null;

    }


    /* In Order traversal other way
    *  Queue<TreeLinkNode> qu = new LinkedList<>();
    if(root != null) {
        qu.add(root);
        while (!qu.isEmpty()) {
            int n = qu.size();
            for (int i = 0; i < n; i++) {
                TreeLinkNode p = qu.remove();
                if (p.left != null) qu.add(p.left);
                if (p.right != null) qu.add(p.right);
                if (i == n - 1) {
                    p.next = null;
                } else {
                    p.next = qu.peek();
                }
            }
        }
    }
    * */

    public static void main(String[] args) {
        Node node7 = new Node(7);
        //Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node2 = new Node(2,node4,node5,null);
        Node node3 = new Node(3,null, node7, null);
        Node node1 = new Node(1,node2, node3, null);

        connect(node1);

    }
}
