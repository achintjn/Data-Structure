import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n:nums){
            map.put(n, map.getOrDefault(n,0)+1);
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

    public int[] topKFrequentMay31(int[] nums, int k) {
        ArrayList<Integer>[] arr = new ArrayList[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int a:nums){
            int cnt = map.getOrDefault(a,0);
            cnt++;
            map.put(a,cnt);
        }

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            if(arr[entry.getValue()]==null)
                arr[entry.getValue()] = new ArrayList<>();
            arr[entry.getValue()].add(entry.getKey());
        }

        int[] res= new int[k];
        int j=0;
        for(int i=nums.length;i>=0;i--){
            if(arr[i]!=null){
                for(int a:arr[i]){
                    if(j<k){
                        res[j] = a;
                        j++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}
