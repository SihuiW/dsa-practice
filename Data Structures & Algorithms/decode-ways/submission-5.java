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
        if(s.charAt(0) == '0') {
            dp[1] = 0;
        } else if(s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }
        
        for(int i = 2; i <= n; i++) {

            // i单独转
            if(s.charAt(i - 1) == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }

            // i和i+1是整体
            char pre = s.charAt(i - 2);
            char cur = s.charAt(i - 1);

            if(pre != '*' && cur != '*') {
                int num = (pre - '0') * 10 + (cur - '0');
                if(num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            if(pre != '*' && cur == '*') {
                int num = pre - '0';
                if(num == 1) {
                    dp[i] += 9 * dp[i - 2];  // 11-19
                } else if(num == 2) {
                    dp[i] += 6 * dp[i - 2];  // 21-26
                }
            }

            if(pre == '*' && cur != '*') {
                int num = cur - '0';
                if(num <= 6 && num >= 0) {
                    dp[i] += 2 * dp[i - 2];
                }else {  // num >= 7 && num <= 9
                    dp[i] += 1 * dp[i - 2];  // *7-*9 只有 1 种
                }
            }

            if(pre == '*' && cur == '*') {
                dp[i] += 15 * dp[i - 2];
            }
          
        }
        return dp[n];
    }
}














