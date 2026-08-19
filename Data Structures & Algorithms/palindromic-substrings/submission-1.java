class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        
        for(int i = n - 1; i >= 0; i--) {  // 改：i从大到小
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {  // 加：判断首尾相等
                    if(j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    
                    if(dp[i][j]) {  // 改：判断后再count
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}