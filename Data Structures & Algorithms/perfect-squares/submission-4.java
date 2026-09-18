class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) dp[i] = i;
        for(int i = 1; i * i <= n; i++) {
            int s = i * i;
            for(int j = s; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - s] + 1);
            }
        }
        return dp[n];
    }
}