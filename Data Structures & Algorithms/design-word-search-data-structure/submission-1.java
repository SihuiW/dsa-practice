class WordDictionary {

    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode p = root;
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
        return f(word, 0, root);
    }

    private boolean f(String word, int idx, TrieNode p) {
        if (idx == word.length()) return p.isEnd;
        char c = word.charAt(idx);
        if (c == '.') {
            for (TrieNode node : p.children) {
                if (node != null && f(word, idx + 1, node)) return true;
            }
        } else {
            TrieNode next = p.children[c - 'a'];
            if (next != null) return f(word, idx + 1, next);
        }
        return false;
    }
}
