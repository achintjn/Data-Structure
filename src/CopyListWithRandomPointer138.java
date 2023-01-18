import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


    class Solution {
        public Node copyRandomList(Node head) {
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
    }
}
