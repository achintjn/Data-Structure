public class SortList148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = new ListNode(-1);
        tail.next = slow;
        while(fast!=null && fast.next!=null){
            tail = tail.next;
            slow=slow.next;
            fast = fast.next.next;
        }
        tail.next = null;
        return merge(sortList(head),sortList(slow));
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode prev = new ListNode(-1);
        ListNode res = prev;
        prev.next = l1;

        while(l1!=null & l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1 = l1.next;
            }
            else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev=prev.next;
        }

        prev.next = l1==null?l2:l1;
        return res.next;
    }
}
