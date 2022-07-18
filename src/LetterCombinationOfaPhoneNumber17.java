import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfaPhoneNumber17 {
    //my solution
    public static List<String> letterCombinations(String digits) {
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});

        char[] chr = digits.toCharArray();
        String s="";
        LinkedList<String> letter = new LinkedList<>();
        combine(chr, letter,s,0,map);
        return letter;
    }

    public static void combine(char[] chr, LinkedList<String> letter, String s, int ctr, Map<Character, Character[]> map){
        if(s.length()==chr.length){
            letter.add(s);
            return;
        }

        Character[] phn = map.get(chr[ctr]);

        for(int i=0;i<phn.length;i++){
            s=s+phn[i];
            combine(chr, letter,s,ctr+1,map);
            s=s.substring(0,s.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
