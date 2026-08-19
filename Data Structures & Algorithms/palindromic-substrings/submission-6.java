class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(c[i] == c[j]) {
                    if(j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j]) res++;
            }
        }
        return res;
    }

    
}
