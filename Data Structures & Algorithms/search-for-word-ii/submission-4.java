class Solution {

    TreeNode tree = new TreeNode();

    class TreeNode {
        TreeNode[] children;
        String word;

        public TreeNode() {
            children = new TreeNode[26];
            word = null;
        }

        public void insert(String word) {
            TreeNode p = tree;
            for(int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if(p.children[c] == null) {
                    p.children[c] = new TreeNode();
                }
                p = p.children[c];
            }
            p.word = word;
        }


    }
    
    List<String> res = new LinkedList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for(String s: words) {
            tree.insert(s);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                f(board, i, j, tree);
            }
        }
        return res;
    }

    void f(char[][] board, int i, int j, TreeNode tree) {
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        char c = board[i][j];

        if(c == '#') return;

        TreeNode next = tree.children[c - 'a'];
        if(next == null) return;

        if(next.word != null) {
            res.add(next.word);
            next.word = null;
        }


        board[i][j] = '#';

        f(board, i - 1, j, next);
        f(board, i + 1, j, next);
        f(board, i, j - 1, next);
        f(board, i, j + 1, next);
        
         
        board[i][j] = c;

    }
}
















