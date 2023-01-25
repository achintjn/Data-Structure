import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    char c;
    boolean isWord;
    HashMap<Character, WordDictionary> map = new HashMap<>();

    public WordDictionary() {

    }

    public void addWord(String word) {
        char[] chr = word.toCharArray();
        Map<Character, WordDictionary> loc_map = this.map;
        WordDictionary obj = new WordDictionary();
        for(char ch:chr){
            if(!loc_map.containsKey(ch)){
                obj = new WordDictionary();
                obj.c=ch;
                loc_map.put(ch,obj);
                loc_map=obj.map;
            }
            else{
                obj = loc_map.get(ch);
                loc_map = obj.map;
            }
        }
        obj.isWord = true;

    }

    public boolean search(String word) {
        char[] chr = word.toCharArray();
        return searchchar(this.map,chr,this);
    }

    public boolean searchchar(Map<Character, WordDictionary> loc_map, char[] chr, WordDictionary curr){

        WordDictionary obj = curr;
        for(int i=0;i<chr.length;i++){
            if(!loc_map.containsKey(chr[i])){
                if(chr[i]=='.'){
                    for(Map.Entry<Character, WordDictionary> loc_map1:loc_map.entrySet()){
                        if(searchchar(loc_map1.getValue().map, Arrays.copyOfRange(chr, i+1,chr.length),loc_map1.getValue()))
                            return true;
                    }
                }
                return false;
            }
            else{
                obj = loc_map.get(chr[i]);
                loc_map = obj.map;
            }
        }
        return curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public class DesignAddandSearchWordsDataStructure211 {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        boolean param_2 = obj.search("bad");
        System.out.println(param_2);
    }
}
