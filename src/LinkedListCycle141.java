import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

    //Hashing technique
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    //fast slow pointer technique
    public boolean hasCycleFS(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow!=null && fast.next!=null ){
            slow=slow.next;
            fast = fast.next.next;
            if(fast==null)
                return false;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
