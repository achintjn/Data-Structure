public class LongestCommonPrefix14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String common = strs[0];

            for(int i=1;i<strs.length && common.length()>0;i++){
                String str = strs[i];
                int min = Math.min(common.length(),str.length());
                int j=0;
                while(j<min){
                    if(common.charAt(j)!=str.charAt(j))
                        break;
                    j++;
                }
                common = str.substring(0,j);
            }
            return common;

        }
    }
}
