import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));
            minHeap.add(intervals[0]);
            int rooms = 1;
            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]>=minHeap.peek()[1])
                    minHeap.poll();
                else
                    rooms++;
                minHeap.add(intervals[i]);
            }
            return rooms;
        }
    }
}
