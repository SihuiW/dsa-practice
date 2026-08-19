class PrefixTree {
    TreeNode tree;

    class TreeNode {
        TreeNode[] children;
        boolean isEnd;

        public TreeNode() {
            this.children = new TreeNode[26];
            this.isEnd = false;
        }
    }

    public PrefixTree() {
         tree = new TreeNode();
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
        p.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode p = tree;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(p.children[c] == null) {
                return false;
            }
            p = p.children[c];
        }
        
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode p = tree;
        for(int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(p.children[c] == null) {
                return false;
            }
            p = p.children[c];
        }
        
        return true;
    }
}
