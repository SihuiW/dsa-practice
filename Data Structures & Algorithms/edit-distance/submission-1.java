class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return f(word1, word2, 0, 0);
    }

    // 操作word1当前字母让它变得跟word2位置的一样需要多少步
    int f(String word1, String word2, int p1, int p2) {
        if(p1 == word1.length()) return word2.length() - p2;
        if(p2 == word2.length()) return word1.length() - p1;
        if(memo[p1][p2] != null) return memo[p1][p2];

        if(word1.charAt(p1) != word2.charAt(p2)) {
            int a = 1 + f(word1, word2, p1, p2 + 1);
            int b = 1 + f(word1, word2, p1 + 1, p2);
            int c = 1 + f(word1, word2, p1 + 1, p2 + 1);
           return memo[p1][p2] = Math.min(Math.min(a,b), c);
        } else {
            return memo[p1][p2] = f(word1, word2, p1 + 1, p2 + 1);
        }
    }
}
