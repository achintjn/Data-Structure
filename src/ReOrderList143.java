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

    public void reorderList2(ListNode head) {
        if(head.next==null || head.next.next==null)
            return;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;

        temp = slow.next;
        slow.next = null;
        while(temp!=null){
            ListNode temp1 = temp.next;
            temp.next = slow;
            slow = temp;
            temp = temp1;
        }

        fast = head;

        while(slow!=null){
            ListNode t1 = fast.next;
            fast.next = slow;
            fast = fast.next;
            slow = slow.next;
            fast.next = t1;
            fast= fast.next;
        }



    }
}
