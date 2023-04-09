public class PalindromeLinkedList234 {

    //first approach space O(n)
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        //find middle
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse
        ListNode temp = slow.next;
        slow.next=null;
        while(temp!=null){
            ListNode third = temp.next;
            temp.next = slow;
            slow = temp;
            temp = third;
        }
        //compare the values
        while(slow!=null){
            if(head.val!=slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //second approach put values in an array and use two pointer to comapre
}
