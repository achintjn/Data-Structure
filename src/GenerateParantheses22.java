import java.util.LinkedList;
import java.util.List;

//learnt and implemented
public class GenerateParantheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList();
        String s = "";
        backtrack(n,s,list,0,0);
        return list;
    }

    public void backtrack(int n, String s, List<String> list,int open, int close){
        if(s.length()==n*2)
        {
            list.add(s);
        }

        if(open<n){
            s=s+'(';
            backtrack(n,s,list,open+1,close);
            s=s.substring(0,s.length()-1);
        }
        if(close<open){
            s=s+')';
            backtrack(n,s,list,open,close+1);
            s=s.substring(0,s.length()-1);
        }
    }
}
