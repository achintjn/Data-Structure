public class ReOrderList143 {
    public void reorderList(ListNode head) {

        ListNode slow=head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        fast = slow.next;
        slow.next = null;
        while(fast!=null){
            ListNode temp = fast.next;
            fast.next = slow;
            slow=fast;
            fast=temp;
        }

        fast = head;

        ListNode tempf=fast.next;


        while(slow.next!=null){
            tempf=fast.next;
            fast.next = slow;
            fast = tempf;
            tempf=slow.next;
            slow.next = fast;
            slow=tempf;
        }
    }
}
