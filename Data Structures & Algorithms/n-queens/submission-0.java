class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        f(0, board);
        return res;
        
    }

    // 一步步去尝试，成功就加入
    void f(int r, char[][] board) {
        if(r == board.length) {
            List<String> list = new ArrayList<>();
            for(char[] row: board) {
                list.add(new String(row));
            }
            res.add(list);
            return;
        }
        for(int c = 0; c < board.length; c++) {
            if(check(r, c, board)) {
                board[r][c] = 'Q';
                f(r + 1, board);
                board[r][c] = '.';
            }

        }
    }

    boolean check(int r, int c, char[][] board) {
        // 查看之前的列有没有冲突
        for(int i = r - 1; i >= 0; i--) {
            if(board[i][c] == 'Q') return false;
        }
        // 查看之前的主对角线有没有冲突
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        // 查看之前的副对角线有没有冲突
        for(int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }

}
