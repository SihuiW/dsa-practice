class PrefixTree {

    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode[] neighbors;
        String word;
        boolean isEnd;

        public TrieNode() {
            this.neighbors = new TrieNode[26];
            word = "";
            isEnd = false;
        }
    }

    public PrefixTree() {
         
    }

    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(p.neighbors[c - 'a'] == null) {
                p.neighbors[c - 'a'] = new TrieNode();
            }
            p = p.neighbors[c - 'a'];
        }
        p.word = word;
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(p.neighbors[c - 'a'] == null) {
                return false;
            }
            p = p.neighbors[c - 'a'];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(p.neighbors[c - 'a'] == null) {
                return false;
            }
            p = p.neighbors[c - 'a'];
        }
        return true;
    }
}
