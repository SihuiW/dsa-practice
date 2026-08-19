class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(j) == s.charAt(i)) {
                    if(j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
