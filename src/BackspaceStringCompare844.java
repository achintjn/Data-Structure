public class BackspaceStringCompare844 {
    public static boolean backspaceCompare(String s, String t) {
        String a=build(s);
        String b=build(t);
        if(a.equals(b))
            return true;
        else
            return false;
    }

    public static String build(String str){
        char[] chr=str.toCharArray();
        String s="";
        for(int i=0;i<chr.length;i++){
            if(chr[i]=='#'){
                if(s.length()>0){
                    s=s.substring(0,s.length()-1);
                }
            }
            else
                s=s+chr[i];
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "a##c";
        String t = "#d#c";
        System.out.println(backspaceCompare(s,t));
    }
}
