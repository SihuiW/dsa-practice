class Solution {
    
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        
        // 2. 答案集（用 Set 去重）
        List<String> result = new ArrayList<>();
        Set<String> found = new HashSet<>();
        
        // 3. 从每个格子开始搜索
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                dfs(board, i, j, root, result, found, visited);
            }
        }
        
        return result;
    }
    
    private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};
    
    private void dfs(char[][] board, int i, int j, TrieNode node, 
                     List<String> result, Set<String> found, boolean[][] visited) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) return;
        
        char c = board[i][j];
        int idx = c - 'a';
        TrieNode next = node.children[idx];
        if (next == null) return;
        
        visited[i][j] = true;
        
        if (next.word != null && !found.contains(next.word)) {
            found.add(next.word);
            result.add(next.word);
        }
        
        for (int[] d : DIRECTIONS) {
            dfs(board, i + d[0], j + d[1], next, result, found, visited);
        }
        
        visited[i][j] = false;
    }
}