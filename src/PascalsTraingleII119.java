import java.util.LinkedList;
import java.util.List;

public class PascalsTraingleII119 {
    class Solution {
        public List<Integer> getRow(int rowIndex) {

            LinkedList<Integer> prev = new LinkedList<>();
            LinkedList<Integer> res = new LinkedList<>();
            prev.add(1);
            if(rowIndex==0)
                return prev;

            for(int i=1;i<=rowIndex;i++){
                res.clear();
                for(int j=1;j<=i+1;j++){
                    if(j==1 || j==i+1)
                        res.add(1);
                    else
                    {
                        res.add(prev.get(j-2)+prev.get(j-1));
                    }
                }
                prev = new LinkedList<>(res);
            }
            return res;

        }
    }
}
