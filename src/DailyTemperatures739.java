import java.util.Stack;

public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int size = temperatures.length;
        int[] res = new int[size];

        for(int i=0;i<size;i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                int[] temp = stack.pop();
                int idx = temp[1];
                res[idx] = i-idx;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return res;
    }
}
