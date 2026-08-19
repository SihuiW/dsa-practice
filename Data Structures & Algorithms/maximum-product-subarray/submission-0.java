class Solution {
    // dp[i...n] 代表从i到j的乘积
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] * nums[j];
            }
        }
        int res = nums[0];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
        
    }
}
