class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length;j++) {
                if(f(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean f(char[][] board, int i, int j, int idx, String word) {
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx) || board[i][j] == '#') return false;

        char c = board[i][j];
        board[i][j] = '#';
        for(int[] d: dir) {
            if(f(board, i + d[0], j + d[1], idx + 1, word)) return true;
        }
        board[i][j] = c;
        return false;
    }

}
