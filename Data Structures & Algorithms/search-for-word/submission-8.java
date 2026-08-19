class Solution {
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                
                if(f(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean f(char[][] board, String word, int p, int i, int j) {
        if(p == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] != word.charAt(p)) return false;
        char prev = board[i][j];
        board[i][j] = '#';

        for(int[] d: dir) {
            if(f(board, word, p + 1, i + d[0], j + d[1])) return true;
        }

        board[i][j] = prev;
        return false;
    }
}
