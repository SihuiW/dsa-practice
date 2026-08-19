class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];  // suffix[i] = piles[i..n-1] 和
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        
        int[][] dp = new int[n + 1][n + 1];  // dp[i][m]，int 默认 0，完美
        for (int i = n - 1; i >= 0; i--) {   // 从后往前填
            for (int m = 1; m <= n; m++) {   // m 从 1 到 n（n=100 够用）
                int maxGet = 0;
                for (int x = 1; x <= Math.min(n - i, 2 * m); x++) {
                    int newM = Math.max(m, x);
                    int oppGet = dp[i + x][newM];  // 对手最大
                    maxGet = Math.max(maxGet, suffix[i] - oppGet);
                }
                dp[i][m] = maxGet;
            }
        }
        return dp[0][1];  // Alice 从 i=0, m=1 开始
    }
}