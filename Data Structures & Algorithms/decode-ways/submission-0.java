class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // 初始化
        dp[0] = 1;  // 空字符串有1种解码方式
        dp[1] = s.charAt(0) == '0' ? 0 : 1;  // 第一个字符
        
        // 填充 dp 数组
        for (int i = 2; i <= n; i++) {
            // 情况1：单独解码 s[i-1]
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // 情况2：s[i-2] 和 s[i-1] 一起解码
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}