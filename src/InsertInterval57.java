import java.util.LinkedList;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        int ADDED = 1000000;
        for(int[] curr:intervals){
            if(newInterval[1]<curr[0]){
                list.add(new int[]{newInterval[0],newInterval[1]});
                list.add(curr);
                newInterval[0]=newInterval[1]=ADDED;
            }else if(newInterval[0]==ADDED || newInterval[0]>curr[1]){
                list.add(curr);
            }else{
                newInterval[0]=Math.min(newInterval[0],curr[0]);
                newInterval[1]=Math.max(newInterval[1],curr[1]);
            }
        }
        if(newInterval[0]!=ADDED)
            list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
