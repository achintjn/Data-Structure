import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;
        Map<String, List<String>> adj = new HashMap<>();
        wordList.add(beginWord);

        String begin = beginWord;
        for(int i=0;i<wordList.size();i++){
            String word = wordList.get(i);

            for(int j=0;j<word.length();j++){
                String key = word.substring(0,j)+'*'+word.substring(j+1,word.length());
                List<String> temp = adj.getOrDefault(key,new ArrayList<>());
                temp.add(word);
                adj.put(key,temp);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord,0);
        map.put(endWord,Integer.MAX_VALUE);
        Queue<String> que = new LinkedList<>();

        que.add(beginWord);

        while(!que.isEmpty()){
            String curr = que.poll();
            for(int j=0;j<curr.length();j++){
                String key = curr.substring(0,j)+'*'+curr.substring(j+1,curr.length());
                for(String neighbor:adj.get(key)){
                    if(!curr.equals(neighbor)){
                        if(map.getOrDefault(neighbor,Integer.MAX_VALUE)>map.get(curr)+1){
                            map.put(neighbor,map.get(curr)+1);
                            que.add(neighbor);
                        }
                    }
                }
            }
        }
        return map.get(endWord)==Integer.MAX_VALUE?0:map.get(endWord)+1;
    }


}
