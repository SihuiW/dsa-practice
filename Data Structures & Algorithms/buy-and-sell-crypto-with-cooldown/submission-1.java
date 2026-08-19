class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 第i天我在0不持有，1持有，2冷冻期的最大利润
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++) {
            // 不持有：前一天不持有/冷冻期结束
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 持有：前一天持有/今天买
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 冷冻期：今天刚卖完
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0],dp[n - 1][2]);
    }
}
