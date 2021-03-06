import java.util.Arrays;
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

    public static boolean checkInclusion2(String s1, String s2) {
       /* int[] chars = new int[128];
        for(int i=0;i<s1.length();i++){
            chars[s1.charAt(i)]++;
        }*/
        int right = s1.length();
        for(int i=0;i<s2.length()-s1.length()+1;i++){
            int sec = i+right;
            String s3 = s2.substring(i,sec);
            if(checkPerm(s3,s1))
                return true;
        }

        return false;

    }

    public static boolean checkPerm(String s,String s1){
        int[] chars = new int[128];
        for(int i=0;i<s1.length();i++){
            chars[s1.charAt(i)]++;
        }

        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)]!=0){
                chars[s.charAt(i)]--;
            }
            else
                return false;
        }
        return true;
    }

    public boolean checkInclusion3(String s1, String s2) {
        char[] ch = new char[26];
        char[] cs1 = s1.toCharArray();
        char[] ch2 = new char[26];
        char[] cs2 = s2.toCharArray();
        int s1_len = s1.length();

        for(int i =0;i<cs1.length;i++){
            ch[cs1[i]-'a']++;
        }

        for(int i =0;i<cs2.length;i++){
            ch2[cs2[i]-'a']++;

            if(i>=s1_len){
                ch2[cs2[i-s1_len]-'a']--;
            }

            if(Arrays.equals(ch,ch2))
                return true;
        }

        return false;

    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("adc","dcda"));

        System.out.println(checkInclusion2("abcdxabcde","abcdeabcdx"));

        System.out.println("achint".substring(0,6));
    }
}
