import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedList1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {

        Map<Integer, Integer> map = new HashMap<>();

        ListNode tail = new ListNode(-1);

        tail.next = head;
        ListNode move = head;
        ListNode move2 = head;
        head = tail;

        while(move!=null){
            map.put(move.val,map.getOrDefault(move.val,0)+1);
            move=move.next;
        }

        while(move2!=null){
            if(map.get(move2.val)>1){
                tail.next = move2.next;
            }else{
                tail=tail.next;
            }
            move2 = move2.next;
        }
        return head.next;

    }
}
