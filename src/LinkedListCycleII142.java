import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII142 {

    //slow fast pointer
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;

            if(slow==fast)
            {
                //It is a simple Math. If you are going full circle you will meet when hare completes two rounds and tortoise complete one round.
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
            if(fast==null)
                return fast;
        }
        return null;

    }

    //hashing
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;

            if(slow==fast)
            {
                slow=head;
                Set<ListNode> set = new HashSet<>();
                while(!set.contains(slow)){
                    set.add(slow);
                    slow=slow.next;
                }
                return slow;
            }
            if(fast==null)
                return fast;
        }
        return null;

    }
}
