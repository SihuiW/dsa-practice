class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n: nums) {
            total += n;
        }
        if(total % 2 != 0) return false;
        int half = total / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for(int n: nums) {
            for(int i = half; i >= n; i--) {
                dp[i] = dp[i - n] || dp[i];
            }
        }
        return dp[half];
    }
}
