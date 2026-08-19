class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') f(board, i, 0);
            if(board[i][n - 1] == 'O') f(board, i, n - 1);
        }
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') f(board, 0, j);
            if(board[m - 1][j] == 'O') f(board, m - 1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void f(char[][] board, int i, int j) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0) return;
        if(board[i][j] == 'X' || board[i][j] == '#') return;
        board[i][j] = '#';
        for(int[] d: dir) {
            f(board, i + d[0], j + d[1]);
        }
    }
}