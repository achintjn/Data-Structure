public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while(k>1){
            slow = slow.next;
            k--;
        }

        ListNode fast_2 = slow;

        while(fast_2.next!=null){
            fast_2=fast_2.next;
            fast = fast.next;
        }

        int val = slow.val;
        slow.val = fast.val;
        fast.val = val;

        return head;
    }
}
