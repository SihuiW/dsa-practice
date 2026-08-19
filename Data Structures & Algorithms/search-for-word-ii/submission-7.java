class Solution {
    TrieNode root = new TrieNode();
    Set<String> res = new HashSet<>();
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }
    public List<String> findWords(char[][] board, String[] words) {
        
        
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.word = w;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                f(board, i, j, root);
            }
        }

        List<String> list = new ArrayList<>();
        for(String s: res) list.add(s);

        return list;

    }

    void f(char[][] board, int i, int j, TrieNode p) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        TrieNode next = p.children[c - 'a'];
        if (next == null) return;
        
        if(!next.word.equals("")) {
            res.add(next.word);
        }

        board[i][j] = '#';
        for(int[] d: dir) {
            f(board, i + d[0], j + d[1], next);
        }
        board[i][j] = c;

    }
}