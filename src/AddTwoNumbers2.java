public class AddTwoNumbers2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode list = new ListNode(-1);
            ListNode head = list;
            int c = 0;
            int a,b=0;
            while(l1!=null || l2!=null){
                a=l1==null?0:(l1.val);
                b=l2==null?0:l2.val;
                int i = a+b;
                if(c==1){
                    i=i+c;
                    c=0;
                }
                if(i>9){
                    i=i%10;
                    c=1;
                }
                list.next = new ListNode(i);
                list = list.next;
                l1 =l1==null?null:l1.next;
                l2=l2==null?null:l2.next;
            }
            if(c==1)
                list.next = new ListNode(c);
            return head.next;

        }
    }

