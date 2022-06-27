import java.util.ArrayList;
import java.util.List;

public class Triangle120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] mat = new Integer[triangle.size()][triangle.size()];
        List<List<Integer>> memo = new ArrayList<>();
        return minTotal(0,0,triangle,mat);
    }
    public static int minTotal( int listIndex, int index, List<List<Integer>> triangle, Integer[][] mat){

        if(listIndex>=triangle.size())
            return 0;
        if(index>=triangle.get(listIndex).size())
            return Integer.MAX_VALUE;
        if(mat[listIndex][index]!=null)
            return mat[listIndex][index];

        int val = triangle.get(listIndex).get(index);

        int val1 = minTotal(listIndex+1, index, triangle, mat);
        int val2 = minTotal(listIndex+1, index+1, triangle, mat);

        int ans = Math.min(val1,val2);
        mat[listIndex][index] = ans+val;

        return ans+val;

    }



    public static void main(String[] args) {
        List l1 = new ArrayList();
        l1.add(2);
        List l2 = new ArrayList();
        l2.add(3);
        l2.add(4);
        List l3 = new ArrayList();
        l3.add(6);l3.add(5);l3.add(7);
        List l4 = new ArrayList();
        l4.add(4);l4.add(1);l4.add(8);l4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        System.out.println(triangle.get(1).get(0));

        System.out.println(minimumTotal(triangle));

    }
}
