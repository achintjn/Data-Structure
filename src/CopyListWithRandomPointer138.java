import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

// Definition for a Node.
static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

        public static Node copyRandomList(Node head) {
            if(head==null)
                return head;
            Map<Node, Node> map = new HashMap<>();
            Node copyHead = new Node(head.val);
            map.put(head,copyHead);

            while(head!=null)
            {
                if(!map.containsKey(head.next)){
                    Node nextNode = head.next;
                    if(nextNode!=null)
                        map.put(nextNode,new Node(nextNode.val));
                }
                map.get(head).next=map.get(head.next);

                if(!map.containsKey(head.random)){
                    Node randomNode = head.random;
                    if(randomNode!=null)
                        map.put(randomNode,new Node(randomNode.val));
                }
                map.get(head).random=map.get(head.random);
                head = head.next;
            }
            return copyHead;
        }

    public static void main(String[] args) {
        Node node = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node;
        node2.random = node4;
        node3.random = node2;
        node4.random = node1;

        copyRandomList(node);

    }
}
