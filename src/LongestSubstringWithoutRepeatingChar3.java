import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar3 {



    public static void main(String[] args) {

        if("asfad".length()==1)
            return ;

        /*char[] c = "dvdf".toCharArray();

        Map<Character, Integer> map = new HashMap();

        int start = 0;
        int max = 0;


        for(int i=0;i<c.length;i++){
            if(map.containsKey(c[i]))
            {
                start = Math.max(map.get(c[i]) + 1, start);
            }

            map.put(c[i],i);
            max = Math.max(max, i - start +1);
        }*/

        /*int n = "dvdf".length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey("dvdf".charAt(j))) {
                i = Math.max(map.get("dvdf".charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put("dvdf".charAt(j), j + 1);
        }*/


            int[] chars = new int[128];

            int left = 0;
            int right = 0;

            int res = 0;
            while (right < "abcdeafbdgcbb".length()) {
                char r = "abcdeafbdgcbb".charAt(right);
                chars[r]++;

                while (chars[r] > 1) {
                    char l = "abcdeafbdgcbb".charAt(left);
                    chars[l]--;
                    left++;
                }

                res = Math.max(res, right - left + 1);

                right++;
            }


        System.out.println(res);
    }
}
