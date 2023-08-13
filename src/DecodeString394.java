import java.util.Stack;

public class DecodeString394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] chr = s.toCharArray();

        for(int i=0;i<chr.length;i++){

            if(chr[i]==']'){
                StringBuilder sb = new StringBuilder("");

                while(!stack.peek().equals("[")){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                int val = Integer.parseInt(stack.pop());
                String append= sb.toString();
                for(int j=1;j<val;j++){
                    sb.append(append);
                }
                stack.push(sb.toString());

            }else{
                if(Character.isDigit(chr[i])){
                    StringBuilder sb = new StringBuilder(String.valueOf(chr[i]));
                    while(i+1<chr.length && Character.isDigit(chr[i+1])){
                        sb.append(String.valueOf(chr[i+1]));
                        i++;
                    }
                    stack.push(sb.toString());
                }
                else{
                    stack.push(String.valueOf(chr[i]));
                }
            }
        }

        StringBuilder res = new StringBuilder("");
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }

        return res.toString();

    }
}
