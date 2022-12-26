public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        boolean exist = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, board, word.toCharArray(), 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int r, int c, char[][] board, char[] word, int index) {
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1 || board[r][c] == '1' || index > word.length || board[r][c] != word[index])
            return false;
        if (index == word.length - 1)
            return true;
        else {
            char c_ = board[r][c];
            board[r][c] = '1';
            boolean exists = false;
            if (dfs(r - 1, c, board, word, index + 1))
                exists = true;
            else if (dfs(r + 1, c, board, word, index + 1))
                exists = true;
            else if (dfs(r, c - 1, board, word, index + 1))
                exists = true;
            else if (dfs(r, c + 1, board, word, index + 1))
                exists = true;
            board[r][c] = c_;
            return exists;
        }
    }

    //this solution is correct but take extra time because we are making whole word at each iteration,
    // instead just check the character keeping track of the index, correct solution in next method
    public static boolean exist2(char[][] board, String word) {

        int[][] track = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (r == 1 && c == 3)
                    System.out.println("deb");
                String match = "";
                //match = match+board[r][c];
                if (dfs(r, c, board, word, match, track))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int r, int c, char[][] board, String word, String match, int[][] track) {
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || match.length() == word.length() || track[r][c] == 1)
            return false;

        if ((match + board[r][c]).equals(word))
            return true;

        track[r][c] = 1;

        if (dfs(r, c + 1, board, word, match + board[r][c], track) ||

                dfs(r + 1, c, board, word, match + board[r][c], track) ||
                dfs(r, c - 1, board, word, match + board[r][c], track) ||
                dfs(r - 1, c, board, word, match + board[r][c], track))
            return true;

        track[r][c] = 0;
        return false;
    }

    //correct solution for prev one, can also remove track and keep changing the board in the same way
    public boolean exist3(char[][] board, String word) {

        int[][] track = new int[board.length][board[0].length];
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(r==1 && c==3)
                    System.out.println("deb");
                String match= "";
                //match = match+board[r][c];
                if(dfs(r,c,board,word,track,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, char[][] board, String word, int[][] track, int idx){
        if(r<0 || c<0 || r==board.length || c==board[0].length || word.charAt(idx)!=board[r][c]|| track[r][c]==1)
            return false;

        if(idx==(word.length()-1))
            return true;

        track[r][c]=1;

        if(dfs(r,c+1,board,word,track,idx+1) ||

                dfs(r+1,c,board,word,track,idx+1) ||
                dfs(r,c-1,board,word,track,idx+1) ||
                dfs(r-1,c,board,word,track,idx+1))
            return true;

        track[r][c]=0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist2(new char[][]{{'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}}, "AAAAAAAAAAAABAA"));
        System.out.println("ABCCED".equals("ABCCED"));
        System.out.println("Achint".substring(1,6));

        StringBuffer s = new StringBuffer("aa");
        s = s.reverse();
        StringBuffer s2 = new StringBuffer("aa");

        System.out.println(s2.equals(s));
    }
}

