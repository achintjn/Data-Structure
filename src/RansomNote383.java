public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chr = new int[26];
        char[] rNote = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for(int i=0;i<rNote.length;i++)
        {
            chr[rNote[i]-'a']++;
        }

        for(int i=0;i<mag.length;i++){
            if(chr[mag[i]-'a'] >0)
            chr[mag[i]-'a']--;
        }

        boolean flag=true;
        for(int i=0;i<chr.length;i++)
        {
            if(chr[i]>0)
                flag=false;
        }

        return flag;
    }
}
