class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        char[] chars = s.toCharArray();
        for(int i = 2; i <= n; i++) {
            int cur = chars[i - 1] - '0';
            int pre = chars[i - 2] - '0';
            if(cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
            }
            int combined = pre * 10 + cur;
            if(combined >= 10 && combined <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
