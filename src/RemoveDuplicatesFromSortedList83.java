public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode tail = head;
        ListNode move = head.next;

        while(move!=null){
            if(tail.val==move.val){
                tail.next = move.next;
                move = move.next;
            }
            else
            {
                tail = tail.next;
                move = move.next;
            }
        }

        return head;

    }
}
