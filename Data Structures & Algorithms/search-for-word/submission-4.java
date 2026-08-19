class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if(f(board, word, i, j, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    boolean f(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        if(idx == word.length()) return true;
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j]) return false;
        char c = board[i][j];
        if(c != word.charAt(idx)) return false;
        visited[i][j] = true;
        for(int[] d: dir) {
            if(f(board, word, i + d[0], j + d[1], idx + 1, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}