class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();
    Integer[] memo;  // memo[i]: 从i开始的最小extra

    public int minExtraChar(String s, String[] dictionary) {
        // 建Trie
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        memo = new Integer[s.length()];
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) return 0;
        if (memo[i] != null) return memo[i];

        // 选项1: 把当前字符当extra跳过
        int min = 1 + dfs(s, i + 1);

        // 选项2: 尝试从i开始的所有完整单词匹配
        TrieNode node = root;
        for (int j = i; j < s.length(); j++) {
            int idx = s.charAt(j) - 'a';
            if (node.children[idx] == null) break;
            node = node.children[idx];
            if (node.isWord) {
                min = Math.min(min, dfs(s, j + 1));  // 这段0 extra + 后续
            }
        }

        return memo[i] = min;
    }
}