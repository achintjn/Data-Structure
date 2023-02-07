import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class MinStack155 {
    Stack<int []> stack;
    public MinStack155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty())
            stack.add(new int[]{val,val});
        else
            stack.add(new int[]{val,(this.getMin()>val?val:this.getMin())});

    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack155 st = new MinStack155();

        st.push(-2);
        st.push(0);
        st.push(-3);

        //st.getMin();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        st.getMin();
        //System.out.println(st.getMin());
    }
}
