import java.util.HashMap;
import java.util.Map;

public class RansomeNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char[] rans = ransomNote.toCharArray();
        char[] magz = magazine.toCharArray();

        char[] chr = new char[26];

        for(char c:magz)
            chr[c-'a']++;

        for(char ch:rans){
            if(chr[ch-'a']<=0)
                return false;
            chr[ch-'a']--;
        }

        return true;
    }
}
