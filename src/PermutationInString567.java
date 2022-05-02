import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {

    /*public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> map = new HashMap();

        char[] chr = s1.toCharArray();

        for(int i=0;i<chr.length;i++)
        {
            if(map.containsKey(chr[i])){
                map.put(chr[i],map.get(chr[i])+1);
            }
            else
            {
                map.put(chr[i],1);
            }
        }

        char[] cs2 = s2.toCharArray();
        int left = 0;
        int right = s1.length()-1;

        while(right<cs2.length){
            String subs = s2.substring(left,right+1);
            Map <Character, Integer> map2 = new HashMap<>();
            map2.putAll(map);
            if(checkperm(map2, subs))
                return true;
            right++;
            left++;
        }

        return false;
    }

    public static boolean checkperm(Map <Character, Integer> map2, String s){
        for(Character c: s.toCharArray())
        {
            if(!map2.containsKey(c))
                return false;

            else
                map2.put(c, map2.get(c)-1);
        }
        for(Character c: map2.keySet())
        {
            if(map2.get(c)!=0)
                return false;
        }

        return true;
    }*/
    /*public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }*/

    //sliding window
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("adc","dcda"));
    }
}
