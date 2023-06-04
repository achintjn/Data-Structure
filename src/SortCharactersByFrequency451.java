import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        ArrayList<Character>[] array = new ArrayList[s.length()+1];
        char[] ch = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();


        for(char c:ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //Character[] tmpArr = ArrayUtils.toObject(ch);

        //Arrays.sort(tmpArr, (a,b)->map.get(b)-map.get(a));

        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            if(array[entry.getValue()]==null)
                array[entry.getValue()] = new ArrayList<>();
            array[entry.getValue()].add(entry.getKey());
        }


        StringBuilder sb = new StringBuilder();
        for(int j=array.length-1;j>0;j--){
            if(array[j]!=null){
                for(char c:array[j]){
                    for(int i=1;i<=j;i++)
                        sb.append(c);
                }
            }
        }

        return sb.toString();


    }
}
