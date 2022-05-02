import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

    public static String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i)))
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            else
                map.put(t.charAt(i),1);
        }

        int required = map.size();

        int formed = 0;

        Map<Character, Integer> windowCount = new HashMap<>();

        int[] ans = {-1, 0, 0};

        while(end<s.length()){
            char c = s.charAt(end);
            int count = windowCount.getOrDefault(c, 0);
            windowCount.put(c, count + 1);

            if(map.containsKey(c) && (map.get(c) == windowCount.get(c))){
                formed++;
            }

            while(formed == required && start<end){
                c = s.charAt(start);
                // Save the smallest window until now.
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;

                }

                windowCount.put(c, windowCount.get(c)-1);
                if(map.containsKey(c) && (map.get(c) > windowCount.get(c)))
                    formed--;

                start++;
            }
            end++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


    public static void main(String[] args) {

        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
