import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> st = new PriorityQueue<>(Collections.reverseOrder());

        for(int wt:stones)
            st.offer(wt);

        while(st.size()>1)
        {
            int one = st.poll();
            int two = st.poll();

            if(one!=two)
                st.offer(one-two);
        }

        return (st.size()!=0)?st.peek():0;

    }
}
