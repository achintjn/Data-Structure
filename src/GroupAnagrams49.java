import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] count = new int[26];
            for(char c: strs[i].toCharArray())
                count[c-'a']++;
            StringBuilder s = new StringBuilder("");
            for(int a:count){
                s.append(a);
                s.append("+");
            }
            System.out.println(s);
            String key = s.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(strs[i]);


        }

        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
    }
}
