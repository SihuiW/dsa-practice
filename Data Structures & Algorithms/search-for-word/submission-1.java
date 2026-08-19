class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(f(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean f(char[][] board, int i, int j, String word, int start) {
        if(start == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(start)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = 
            f(board, i - 1, j, word, start + 1) ||
            f(board, i + 1, j, word, start + 1) ||
            f(board, i, j - 1, word, start + 1) ||
            f(board, i, j + 1, word, start + 1);
        

        board[i][j] = temp;

        return found;
        
    }
}
