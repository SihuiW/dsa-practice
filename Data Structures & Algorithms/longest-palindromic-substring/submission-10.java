class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int max = 1;
        for(int i = 0; i < n; i++) {
            dp[i][i] = true; 
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    int l = j - i + 1;
                    if(l > max) {
                        start = i;
                        max = l;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}
