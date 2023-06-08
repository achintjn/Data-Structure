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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode res = l3;

        int carry = 0;
        while(l2!=null || l1!=null){
            int x = l1==null?0:l1.val;
            int y = l2==null?0:l2.val;
            int cal = x + y + carry;
            carry=0;
            if(cal>=10){
                cal = cal-10;
                carry = 1;
            }
            l3.next = new ListNode(cal);
            l3 = l3.next;
            l2 = l2==null?null:l2.next;
            l1 = l1==null?null:l1.next;
        }

        if(carry!=0)
            l3.next = new ListNode(carry);

        return res.next;

    }
    }

