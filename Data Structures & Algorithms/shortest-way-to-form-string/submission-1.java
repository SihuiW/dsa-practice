class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length();
        int[][] next = new int[m + 1][26];
        for(int i = 0; i < 26; i++) {
            next[m][i] = -1;
        }
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            next[i][source.charAt(i) - 'a'] = i;
        }
        int res = 1;
        int pos = 0;
        for(int i = 0; i < target.length(); i++) {
            int idx = target.charAt(i) - 'a';

            if (next[0][idx] == -1) return -1;

            if(next[pos][idx] != -1) {
                pos = next[pos][idx] + 1;
            } else {
                res++;
                pos = next[0][idx] + 1;
            }
        }
        return res;

    }
}