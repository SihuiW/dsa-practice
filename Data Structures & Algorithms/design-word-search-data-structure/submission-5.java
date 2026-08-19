class WordDictionary {

    TrieNode tree = new TrieNode();

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode p = tree;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = tree;
        return f(word, 0, p);
    }

    boolean f(String word, int idx, TrieNode p) {
        if(p == null) return false;
        if(idx == word.length()) return p.isEnd;
        char c = word.charAt(idx);
        if(c == '.') {
            for(TrieNode node: p.children) {
                if(f(word, idx + 1, node)) {
                    return true;
                }
            }
            return false;
        }
            
        return f(word, idx + 1, p.children[c - 'a']);
        
    }
}
