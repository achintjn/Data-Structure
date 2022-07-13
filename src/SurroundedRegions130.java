public class SurroundedRegions130 {
    public static void solve(char[][] board) {
        int r_len = board.length;
        int c_len = board[0].length;

        if(r_len>2 && c_len>2){
            int [][] visited = new int[r_len][c_len];

            for(int r=0;r<r_len;r++){
                if(board[r][0]=='O')
                    dfs(r,0,board, visited);
                if(board[r][c_len-1]=='O')
                    dfs(r,c_len-1,board, visited);

            }
            for(int c=0;c<c_len;c++){
                if(board[0][c]=='O')
                    dfs(0,c,board, visited);
                if(board[r_len-1][c]=='O')
                    dfs(r_len-1,c,board, visited);
            }

            for(int r=0;r<r_len;r++){
                for(int c=0;c<c_len;c++){
                    if(visited[r][c]==1)
                        continue;
                    else
                        board[r][c]='X';
                }
            }
        }



    }

    public static void dfs(int r, int c, char[][] board, int[][]visited){
        if(r<0 || r>board.length-1 || c<0 || c>board[0].length-1 || board[r][c]!='O' || visited[r][c]==1)
            return;
        visited[r][c]=1;
        dfs(r-1,c,board,visited);
        dfs(r+1,c,board,visited);
        dfs(r,c-1,board,visited);
        dfs(r,c+1,board,visited);
    }

    public static void main(String[] args) {
        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}
