public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        boolean exist = false;
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                    if(dfs(r,c,board,word.toCharArray(),0))
                        return true;
            }
        }
        return false;
    }

    public static boolean dfs(int r, int c, char[][] board, char[] word, int index){
        if(r<0 || r>board.length-1 || c<0 || c>board[0].length-1 || board[r][c]=='1' || index>word.length ||board[r][c]!=word[index])
            return false;
        if(index==word.length-1)
            return true;
        else {
            char c_ = board[r][c];
            board[r][c] = '1';
            boolean exists = false;
            if (dfs(r-1,c,board,word,index+1))
                exists = true;
            else if (dfs(r+1,c,board,word,index+1))
                exists = true;
            else if(dfs(r,c-1,board,word,index+1))
                exists = true;
            else if(dfs(r,c+1,board,word,index+1))
                exists = true;
            board[r][c] = c_;
            return exists;
        }
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B'},{'S','F'}},"ASF"));
        System.out.println("ABCCED".equals("ABCCED"));
        System.out.println(false || false || false || true || false || false );
    };
}
