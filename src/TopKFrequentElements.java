import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }
            else
                map.put(n,1);
        }

        //int[] res = new int[nums.length+1];
        ArrayList<Integer>[] res = new ArrayList[nums.length+1];
        int[] result = new int[k];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(res[entry.getValue()]==null)
                res[entry.getValue()] = new ArrayList<>();
            res[entry.getValue()].add(entry.getKey());
        }

        int j=0;
        for(int i=res.length-1;i>=0;i--){
            if(res[i]!=null){
                for(int fill:res[i]){
                    result[j]=fill;
                    j++;
                    if(j==k)
                        return result;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}
