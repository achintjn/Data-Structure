public class ReverseLinkedList206 {
    public static ListNode reverseList(ListNode head) {

        ListNode tail = null;

        if (head == null)
            return null;

        tail = reversal(head.next, tail);
        head.next.next = head;
        head.next = null;

        return tail;
    }

    public static ListNode reversal(ListNode head, ListNode tail) {
        if (head.next == null) {
            tail = head;
            return tail;
        }
        tail = reversal(head.next, tail);

        head.next.next = head;

        return tail;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode third = new ListNode(-1,null);
        ListNode last = third.next;

        while(head!=null){
            third.next = head;
            head = head.next;
            third.next.next = last;
            last = third.next;
        }

        return third.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(5,null);
        ListNode node = new ListNode(4,node1);
        ListNode node_ = new ListNode(3,node);
        ListNode node_1 = new ListNode(2,node_);
        ListNode node_fin = new ListNode(1,node_1);

        reverseList(node_fin);
    }

}
