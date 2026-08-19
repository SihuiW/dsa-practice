class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] travel = new boolean[lastDay + 1];

        for (int day : days) {
            travel[day] = true;
        }

        int[] dp = new int[lastDay + 1];

        for (int d = 1; d <= lastDay; d++) {
            if (!travel[d]) {
                dp[d] = dp[d - 1];
            } else {
                dp[d] = Math.min(
                    dp[d - 1] + costs[0],
                    Math.min(
                        dp[Math.max(0, d - 7)] + costs[1],
                        dp[Math.max(0, d - 30)] + costs[2]
                    )
                );
            }
        }

        return dp[lastDay];
    }
}