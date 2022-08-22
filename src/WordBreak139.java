import java.util.*;

public class WordBreak139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        char[] chr = s.toCharArray();
        int start=0;
        int end=0;
        int count=0;
        int wordCount = wordDict.size();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<chr.length;i++){
            end=i;
            String sub = s.substring(start,end+1);
            if(map.containsKey(sub))
            {
                start=end+1;
            }
            else if(wordDict.contains(sub)){
                map.put(sub,1);
                start=end+1;
                count++;
            }
        }
        return (start==end+1)?  true:  false;

    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        char[] chr = s.toCharArray();
        int start=0;
        int end=chr.length;
        int count=0;
        int wordCount = wordDict.size();
        Map<String, Integer>  map = new HashMap<>();

        while(start!=end){
            String sub = s.substring(start,end);
            if(map.containsKey(sub))
            {
                end=start;
                start=0;

            }
            else if(wordDict.contains(sub)){
                map.put(sub,1);
                end=start;
                start=0;

            }
            else
                start++;
        }

        /*for(int i=0;i<chr.length;i++){
            end=i;
            String sub = s.substring(start,end+1);
            if(map.containsKey(sub))
            {
                start=end+1;
            }
            else if(wordDict.contains(sub)){
                map.put(sub,1);
                start=end+1;
                count++;
            }
        }*/
        return (start==0 && end==0)?  true:  false;

    }

    public static boolean wordBreak3(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private static boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak4("leetcode", list));
    }
}
