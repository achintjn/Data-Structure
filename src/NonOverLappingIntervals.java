import java.util.Arrays;
import java.util.LinkedList;

public class NonOverLappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals,(a, b)->a[0]-b[0]);

            int count = 0;
            LinkedList<int[]> list = new LinkedList<>();
            list.add(new int[]{intervals[0][0],intervals[0][1]});
            for(int i=1;i<intervals.length;i++)
            {
                int[] prev = list.getLast();
                if(intervals[i][0]<prev[1]){
                    count++;
                    if(prev[1]>intervals[i][1]){
                        list.removeLast();
                        list.add(new int[]{intervals[i][0],intervals[i][1]});
                    }
                }else{
                    list.add(new int[]{intervals[i][0],intervals[i][1]});
                }
            }
            return count;
        }
    }
}
