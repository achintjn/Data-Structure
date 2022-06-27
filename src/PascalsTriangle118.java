import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            small.clear();
            if(i==1)
                small.add(1);
            else if(i==2){
                small.add(1);
                small.add(1);
            }
            else{
                for(int j=0;j<i;j++){
                    if(j==0 || j==i-1){
                        small.add(1);
                    }
                    else{
                        small.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
                    }
                }
            }
            list.add(new ArrayList<>(small));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
