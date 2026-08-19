class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.max(dp[i][j], points[i][j] + dp[i - 1][k] - Math.abs(j - k));
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            res = Math.max(res, dp[m - 1][j]);
        }
        return res;
    }
}