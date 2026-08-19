class PrefixTree {

    TreeNode root = new TreeNode();

    class TreeNode {
        int p;
        int e;
        TreeNode[] nexts;

        public TreeNode() {
            this.p = 0;
            this.e = 0;
            this.nexts = new TreeNode[26];
        }
    }

    public PrefixTree() {
         
    }

    public void insert(String word) {
        TreeNode p = root;
        for(int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if(p.nexts[path] == null) {
                p.nexts[path] = new TreeNode();
            }
            p = p.nexts[path];
            p.p++;
        }
        p.e++;
    }

    public void erase(String word) {
        if(countWordsEqualTo(word) == 0) return;
        TreeNode p = root;
        p.p--;
        for(int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if(--p.nexts[path].p == 0) {
                p.nexts[path] = null;
                return;
            }
            p = p.nexts[path];
        }
        p.e--;
    }

    public boolean search(String word) {
        if(countWordsEqualTo(word) == 0) return false;
        return true;
    }

    public int countWordsEqualTo(String word) {
        TreeNode p = root;
        for(int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if(p.nexts[path] == null) return 0;
            p = p.nexts[path];
        }
        return p.e;
    }

    public boolean startsWith(String prefix) {
        TreeNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            int path = prefix.charAt(i) - 'a';
            if(p.nexts[path] == null) return false;
            p = p.nexts[path];
        }
        return true;
    }
}
