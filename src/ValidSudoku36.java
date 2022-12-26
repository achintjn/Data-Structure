import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set_1 = new HashSet<>();
        Set<Character> set_2 = new HashSet<>();
        Set<Character> set_3 = new HashSet<>();
        for(int r=0;r<board.length;r++){
            Set<Character> set_row = new HashSet<>();

            if(r==0 || r==3 || r==6){
                set_1 = new HashSet<>();
                set_2 = new HashSet<>();
                set_3 = new HashSet<>();
            }

            for(int c=0;c<board[0].length;c++){
                if(board[r][c]=='.')
                    continue;
                if(set_row.contains(board[r][c]))
                    return false;
                set_row.add(board[r][c]);
                if(c<3){
                    if(set_1.contains(board[r][c]))
                        return false;
                    set_1.add(board[r][c]);
                }
                if(c<6 && c>2){
                    if(set_2.contains(board[r][c]))
                        return false;
                    set_2.add(board[r][c]);
                }
                if(c<9 && c>=6){
                    if(set_3.contains(board[r][c]))
                        return false;
                    set_3.add(board[r][c]);
                }

            }
        }

        for(int r=0;r<board[0].length;r++){
            Set<Character> set_col = new HashSet<>();
            for(int c=0;c<board.length;c++){
                if(board[c][r]=='.')
                    continue;
                if(set_col.contains(board[c][r]))
                    return false;
                set_col.add(board[c][r]);
            }
        }


        return true;

    }
}
