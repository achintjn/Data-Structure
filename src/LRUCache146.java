import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    class Doubly{
        int val;
        int k;
        Doubly next;
        Doubly prev;

        public Doubly(int val, int k){
            this.val=val;
            this.k = k;
        }
    }

    class LRUCache {
        Map<Integer, Doubly> map;
        Doubly head;
        Doubly tail;
        int size;
        int curr_size = 0;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new Doubly(0,0);
            tail = new Doubly(0,0);
            head.next = tail;
            tail.prev = head;
            this.size = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){

                Doubly node = map.get(key);
                if(node.next!=tail){
                    Doubly first = node.prev;
                    Doubly last = node.next;
                    first.next = node.next;
                    last.prev = node.prev;


                    node.prev = tail.prev;
                    tail.prev = node;
                    node.prev.next = node;
                    node.next = tail;
                }
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Doubly node = map.get(key);
                if(node.next!=tail){
                    Doubly first = node.prev;
                    Doubly last = node.next;
                    first.next = node.next;
                    last.prev = node.prev;

                    node.prev = tail.prev;
                    tail.prev = node;
                    node.prev.next = node;
                    node.next = tail;
                }
                node.val = value;
            }
            else{
                if(curr_size==size){
                    Doubly delete = head.next ;
                    delete.next.prev = delete.prev;
                    head.next = delete.next;
                    map.remove(delete.k);
                    curr_size--;
                }
                Doubly node = new Doubly(value,key);
                node.prev = tail.prev;
                tail.prev = node;
                node.prev.next = node;
                node.next = tail;
                map.put(key,node);
                curr_size++;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
