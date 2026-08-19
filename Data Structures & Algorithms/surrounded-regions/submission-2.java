class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        for(int[] d: dir) {
            dfs(board, i + d[0], j + d[1]);
        }
    }
}
