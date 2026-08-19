class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Base case 1: 起点
        dp[0][0] = 1;
        
        // Base case 2: 第一行（只能从左边来）
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;  // 应该填什么？
        }
        
        // Base case 3: 第一列（只能从上边来）
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;  // 应该填什么？
        }
        
        // 填充其他格子
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];  // 状态转移方程是什么？
            }
        }
        
        return dp[m-1][n-1];
    }
}