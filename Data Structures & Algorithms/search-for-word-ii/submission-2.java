class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        for(String word: words) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(f(board, word,i,j,0)) res.add(word);
                }
            }
        }
        return new LinkedList<>(res);
    }

    boolean f(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) return true;
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;

        if(board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';

        boolean res = f(board, word, i - 1, j, index + 1) || 
                        f(board, word, i + 1, j, index + 1) ||
                        f(board, word, i, j - 1, index + 1) ||
                        f(board, word, i, j + 1, index + 1);
        
        board[i][j] = temp;
        return res;

    }
}
