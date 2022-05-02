public class MergeTwoSortedList21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head, tail = null;

        if(list1==null && list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

        if(list1.val<list2.val)
        {
            head = list1;
            tail = list1;
            list1 = list1.next;
        }
        else
        {
            head = list2;
            tail = list2;
            list2 = list2.next;
        }

        while(list1!=null && list2!=null){

            if(list1==null){
                tail.next = list2;
                break;
            }

            if(list2 == null){
                tail.next = list1;
                break;
            }

            if(list2.val<list1.val){
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
            else{
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4,null);
        ListNode node = new ListNode(2,node1);
        ListNode node_ = new ListNode(1,node);

        ListNode node2 = new ListNode(4,null);
        ListNode node2_ = new ListNode(3,node2);
        ListNode node1_ = new ListNode(1,node2_);

        ListNode head = mergeTwoLists(node_, node1_);

        while(head!=null){
            System.out.println(head.val);

            head = head.next;
        }

    }

}
