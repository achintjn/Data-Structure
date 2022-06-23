import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations77 {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k2)
            output2.add(new LinkedList(curr));

         for (int i = first; i < n2 + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n2 = n;
        this.k2 = k;
        backtrack(1, new LinkedList<Integer>());
        return output2;
    }

    public static void main(String[] args) {
        Combinations77 com = new Combinations77();
        List<List<Integer>> list = com.combine(4,2);

        for(List<Integer> list1: list){
            System.out.println("--");
            for(int i: list1){
                System.out.println(i);
            }
            System.out.println("--");
        }
    }

    List<List<Integer>> output2 = new ArrayList<>();
    int n2 ;int k2;
    public List<List<Integer>> combine2(int n, int k) {
        this.n2=n;
        this.k2 =k;
        ArrayList<Integer> curr = new ArrayList<>();
        backtrack2(0,curr);
        return output2;
    }

    public void backtrack2(int start, ArrayList<Integer> curr){

        if(curr.size()== k2)
            output2.add(new ArrayList(curr));

        for(int i=start+1;i<=n2 ;i++){
            curr.add(i);
            backtrack2(i,curr);
            curr.remove(curr.size()-1);
        }
    }
}
