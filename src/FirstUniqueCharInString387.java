import java.util.LinkedHashMap;
import java.util.Map;
public class FirstUniqueCharInString387 {
    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap();
        char [] char1 = s.toCharArray();
        for(int i=0; i<s.length();i++){
            if(map.containsKey(char1[i]))
                map.put(char1[i],map.get(char1[i])+1);
            else
                map.put(char1[i],1);
        }

        for(int i=0; i<s.length();i++){
            if(map.get(char1[i]) == 1)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        String s ="leetcode";
        int [] arr = new int[10];
        arr[2]++;
        System.out.println(arr[2]);

        System.out.println(firstUniqChar(s));
    }
}
