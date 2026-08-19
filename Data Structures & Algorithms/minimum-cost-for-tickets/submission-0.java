class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        boolean[] isTravelDay = new boolean[dp.length];
        for (int day : days) isTravelDay[day] = true;

        for(int i = 1; i < dp.length; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int cost1 = dp[i - 1] + costs[0];
            int cost7 = dp[Math.max(0, i - 7)] + costs[1];
            int cost30 = dp[Math.max(0, i - 30)] + costs[2];
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }
        return dp[dp.length - 1];
    }
}