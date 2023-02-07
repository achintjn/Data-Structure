import java.util.Stack;

public class EvaluateReversePolishedNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
            if(!s.equals("+")&&!s.equals("*")&&!s.equals("/")&&!s.equals("-"))
            {
                st.add(Integer.parseInt(s));
            }else{
                int x = st.pop();
                int y = st.pop();
                if(s.equals("+")){
                    st.add(x+y);
                }else if(s.equals("/")){
                    st.add(y/x);
                }else if(s.equals("-")){
                    st.add(y-x);
                }else{
                    st.add(x*y);
                }
            }
        }
        return st.pop();

    }
}
