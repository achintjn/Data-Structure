public class RemoveDuplicatesFromSortedListII82 {
    public static ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }

    //mysolution
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode sentinal = new ListNode(0,head);

        ListNode prev=sentinal;

        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
                prev.next=head.next;
                head=head.next;
            }
            else{
                prev.next=head;
                prev=head;
                head=head.next;

            }
        }
        return sentinal.next;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(5,null);
        ListNode node6 = new ListNode(4,node7);
        ListNode node5 = new ListNode(4,node6);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node = new ListNode(1,node2);

        ListNode head = node;

        deleteDuplicates2(head);
    }
}
