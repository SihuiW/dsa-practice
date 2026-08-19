class Solution {
    public boolean exist(char[][] board, String word) {
        // 1. 遍历每个格子作为起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;  // 填空A
                }
            }
        }
        return false;  // 填空B
    }
    
    boolean dfs(char[][] board, String word, int i, int j, int start) {
        // 2. 成功条件
        if (start == word.length()) {
            return true;  // 填空C
        }
        
        // 3. 失败条件
        if (i < 0 || i >= board.length || 
            j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(start)) {
            return false;  // 填空D
        }
        
        // 4. 标记已访问
        char temp = board[i][j];
        board[i][j] = 'C';  // 填空E：用什么标记？
        
        // 5. 四个方向递归
        boolean found = 
            dfs(board, word, i-1, j, start+1) ||  // 填空F: 上
            dfs(board, word, i+1, j, start+1) ||  // 填空G: 下
            dfs(board, word, i, j-1, start+1) ||  // 填空H: 左
            dfs(board, word, i, j+1, start+1);    // 填空I: 右
        
        // 6. 回溯
        board[i][j] = temp;  // 填空J
        
        return found;
    }
}