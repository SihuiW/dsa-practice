class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 持股1，不持股0的利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            // 今天不持股：昨天持股今天卖了，昨天不持股
           dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
           // 今天持股：昨天持股今天卖了又买，昨天不持股今天买了
           dp[i][1] = Math.max(dp[i - 1][1] + prices[i] - prices[i], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}