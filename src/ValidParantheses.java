import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();

        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> st = new Stack<>();

        char[] ch = s.toCharArray();

        for(char c:ch){
            if(st.isEmpty() || map.containsKey(c))
                st.push(c);
            else if(c==map.getOrDefault(st.peek(),'x')){
                st.pop();
            }
            else
                return false;
        }

        return st.isEmpty()?true:false;

    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');


        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && c==map.getOrDefault(stack.peek(),'.'))
                stack.pop();
            else
                stack.push(c);
        }

        if(stack.isEmpty())
            return true;
        return false;
    }
}
