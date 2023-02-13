import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestsubstringwithAtmostkDistinctChar340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0)
            return 0;
        int left = 0;
        //int right =2;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        char last = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
            if(map.size()>k){
                int idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                left = idx +1;
            }

            max = Math.max(max, i-left+1);
        }

        return max;
    }
}
