class Solution {
    // dp[i] 长度是i的有几种解码方式
    //123
    // base case
        // dp[0] = 1
        // dp[1] 如果不是0 就是1种
        // dp[n] 要么单独算最后这位 也就是跟n-1是一样的
        // 要么看最后两位是不是在10-26之间 是就是跟n-2一样
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0: 1;
        for(int i = 2; i <= n; i++) {
          if(s.charAt(i - 1) != '0') {
            dp[i] += dp[i - 1];
          }
          int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
          if(num >= 10 && num <= 26) {
            dp[i] += dp[i - 2];
          }
        }
        return dp[n];
    }
}
