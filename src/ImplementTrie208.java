import java.util.HashMap;
import java.util.Map;
class Trie {

    char c;
    boolean isWord;
    Map<Character, Trie> map = new HashMap<>();

    public Trie() {
    }

    public void insert(String word) {
        char[] chr = word.toCharArray();
        Map<Character, Trie> loc_map = this.map;
        Trie obj = new Trie();
        for(char ch:chr){
            if(!loc_map.containsKey(ch)){
                obj = new Trie();
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
        Map<Character, Trie> loc_map = this.map;
        Trie obj = new Trie();
        for(char ch:chr){
            if(loc_map.containsKey(ch))
            {
                obj = loc_map.get(ch);
                loc_map = obj.map;
            }
            else
                return false;
        }
        return obj.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] chr = prefix.toCharArray();
        Map<Character, Trie> loc_map = this.map;
        Trie obj = new Trie();
        for(char ch:chr){
            if(loc_map.containsKey(ch))
            {
                obj = loc_map.get(ch);
                loc_map = obj.map;
            }
            else
                return false;
        }
        return true;
    }
}

public class ImplementTrie208 {


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public static void main(String[] args) {
    Trie trie_main = new Trie();
    trie_main.insert("apple");
    boolean param_2 = trie_main.search("apple");
    System.out.println(param_2);
}
}
