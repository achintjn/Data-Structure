public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tail = new ListNode(-1);
        ListNode move = head;
        head = tail;

        while(move!=null){
            if(move.val==val){
                tail.next = move.next;
                move=move.next;
            }
            else{
                tail.next = move;
                tail=tail.next;
                move=move.next;
            }
        }

        return head.next;
    }
}
