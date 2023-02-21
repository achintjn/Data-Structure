import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWIthAtMost2DistinctChar159 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        //int right =2;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        char last = s.charAt(0);
        for(int i=1;i<s.length();i++){
            map.put(s.charAt(i),i);
            if(map.size()==3){
                // delete the leftmost character
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }
            max = Math.max(max, i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
