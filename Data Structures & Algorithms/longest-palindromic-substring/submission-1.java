class Solution {
    public String longestPalindrome(String s) {
    int n = s.length();
    if(n < 2) return s;
    
    boolean[][] dp = new boolean[n][n];
    int maxLen = 1;      // 记录最长回文的长度
    int start = 0;       // 记录最长回文的起点
    
    // 初始化：所有长度为1的子串都是回文
    for(int i = 0; i < n; i++) {
        dp[i][i] = true;
    }
    
    // 遍历
    for(int i = n - 1; i >= 0; i--) {
        for(int j = i; j < n; j++) {
            // TODO: 你来填
            if(s.charAt(i) == s.charAt(j)) {
                if(j - i <= 1) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
            // 1. 判断 s.charAt(i) 和 s.charAt(j) 是否相等
            // 2. 如果相等，再判断长度
            // 3. 更新 maxLen 和 start
        }
    }
    
    return s.substring(start, start + maxLen);
}
}
