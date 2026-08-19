class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int w: stones) {
            sum += w;
        }
        boolean[] dp = new boolean[(sum / 2) + 1];
        dp[0] = true;
        for(int w: stones) {
            for(int i = sum / 2; i >= w; i--) {
                dp[i] = dp[i] || dp[i - w];
            }
        }
        int half = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i]) {
                half = Math.max(half, i);
            }
        }
        int res = sum - half - half;
        return res;
    }
}