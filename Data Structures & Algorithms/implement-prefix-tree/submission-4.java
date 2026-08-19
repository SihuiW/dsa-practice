class PrefixTree {
    TrieNode tree = new TrieNode();

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public PrefixTree() {}

    public void insert(String word) {
        TrieNode p = tree;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = tree;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = tree;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return true;
    }
}
