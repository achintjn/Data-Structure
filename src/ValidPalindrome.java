public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        char [] ch = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c:ch){
            if(!Character.isLetter(c) && !Character.isDigit(c))
                continue;
            else
                sb = sb.append(c);
        }

        int i = 0;
        int j = sb.length()-1;

        while(i<=j){
            if(sb.charAt(i)!=sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}
