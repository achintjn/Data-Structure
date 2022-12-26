import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning131 {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new LinkedList<>();
            LinkedList<String> list = new LinkedList<>();
            backtrack(1,s,list,res);
            return res;
        }

        public void backtrack(int pos, String s,LinkedList<String> list ,List<List<String>> res){
            if(pos>s.length())
                res.add(new LinkedList<>(list));


            for(int i=pos;i<=s.length();i++){
                String temp = s.substring(0,i);
                if(isPalindrome(temp)){
                    list.add(temp);
                    backtrack(1,s.substring(i,s.length()),list,res);
                    list.removeLast();
                }



            }
        }

        public boolean isPalindrome(String s1){
            StringBuilder s = new StringBuilder(s1);


            return s1.equals(s.reverse().toString());
        }
    }

