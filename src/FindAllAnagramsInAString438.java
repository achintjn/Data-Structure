import java.util.*;

public class FindAllAnagramsInAString438 {
    //my solution
    public static List<Integer> findAnagrams(String s, String p) {
        char[] chr = p.toCharArray();
        int p_len = p.length();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<p_len;i++){
            if(map.containsKey(chr[i]))
                map.put(chr[i], map.get(chr[i])+1);
            else
                map.put(chr[i],1);
        }

        char[] chrs = s.toCharArray();
        List<Integer> list = new ArrayList();

        for(int i=0; i<chrs.length;i++){
            if(map2.containsKey(chrs[i]))
                map2.put(chrs[i], map2.get(chrs[i])+1);
            else
                map2.put(chrs[i],1);

            if(i>=p_len){
                if(map2.get(chrs[i-p_len])==1)
                    map2.remove(chrs[i-p_len]);
                else
                    map2.put(chrs[i-p_len],map2.get(chrs[i-p_len])-1);
            }
            if(map.equals(map2))
                list.add(i-p_len+1);
        }
        return list;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        Map<Character, Integer> pCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();
        // build reference hashmap using string p
        for (char ch : p.toCharArray()) {
            if (pCount.containsKey(ch)) {
                pCount.put(ch, pCount.get(ch) + 1);
            }
            else {
                pCount.put(ch, 1);
            }
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            }
            else {
                sCount.put(ch, 1);
            }
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                ch = s.charAt(i - np);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                }
                else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            // compare hashmap in the sliding window
            // with the reference hashmap
            if (pCount.equals(sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }


    public static List<Integer> findAnagrams3(String s, String p) {
            int[] ch = new int[26];
            char[] cs1 = p.toCharArray();
            int[] ch2 = new int[26];
            char[] cs2 = s.toCharArray();
            int s1_len = p.length();

            for(int i =0;i<cs1.length;i++){
                ch[cs1[i]-'a']++;
            }

            List<Integer> output = new ArrayList();
            for(int i =0;i<cs2.length;i++){
                ch2[cs2[i]-'a']++;

                if(i>=s1_len){
                    ch2[cs2[i-s1_len]-'a']--;
                }

                if(Arrays.equals(ch,ch2))
                    output.add(i - s1_len + 1);
            }

            return output;
        }

    public static List<Integer> findAnagrams4(String s, String p) {
        int start = 0;
        int end = p.length()-1;
        List<Integer> list = new ArrayList<>();
        int[] p_26 = new int[26];
        int i=0;
        while(i<=p.length()-1){
            p_26[p.charAt(i)-'a']++;
            i++;
        }

        int[] s_26 = new int[26];
        int j=0;
        while(j<=p.length()-1){
            s_26[s.charAt(j)-'a']++;
            j++;
        }

        while(end<=s.length()-1){
            String temp = s.substring(start, end);
            if(start!=0)
                s_26[s.charAt(end)-'a']++;
            if(Arrays.equals(p_26,s_26))
                list.add(start);

            s_26[s.charAt(start)-'a']--;
            start++;
            end++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams4("cbaebabacd","abc" ));
    }
}
