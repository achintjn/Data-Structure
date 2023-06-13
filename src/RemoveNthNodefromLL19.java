 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class RemoveNthNodefromLL19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i=0;i<=n;i++){
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == head ){
            head = head.next;
        }
        else
            slow.next = slow.next.next;

        //slow.next = slow.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast==null){
            head = head.next;
            return head;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = slow.next.next;


        return head;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2,null);
        ListNode node = new ListNode(1,node2);

        ListNode head = node;

        ListNode x = removeNthFromEnd(head, 2);

        while(x != null){
            System.out.println(x.val);
            x = x.next;
        }

    }
}
