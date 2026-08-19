class WordDictionary {

    TreeNode dict;

    class TreeNode {
        TreeNode[] children;
        boolean isEnd;

        public TreeNode() {
            this.children = new TreeNode[26];
            this.isEnd = false;
        }
    }

    public WordDictionary() {
        dict = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode p = dict;
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
        return f( word,  0,  dict);
    }

    boolean f(String word, int index, TreeNode dict) {
        if(index == word.length()) {
            return dict.isEnd;
        }

        char c = word.charAt(index);

        if(c != '.') {
            if(dict.children[c - 'a'] == null) {
                return false;
            } 
            return f(word, index + 1, dict.children[c - 'a']);
               
        } else {
            for(int i = 0; i < 26; i++) {
                if(dict.children[i] != null) {
                    if(f(word, index + 1, dict.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
