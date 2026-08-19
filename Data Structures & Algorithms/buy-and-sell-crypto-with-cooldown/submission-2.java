class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 利润：0-不持股无冷静期 1-不持股有冷静期 2-持股
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        for(int i = 1; i < n; i++) {
            // 前一天不持股无冷静期，前一天不持股有冷静期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 前一天持股然后卖了
            dp[i][1] = dp[i - 1][2] + prices[i];
            // 前一天不持股无冷静期, 今天买了，昨天就持股
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
