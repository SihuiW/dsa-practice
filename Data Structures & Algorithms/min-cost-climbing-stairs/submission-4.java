class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;
        for(int i = 2; i <= cost.length; i++) {
            int temp = two;
            two = Math.min(two + cost[i - 1], one + cost[i - 2]);
            one = temp;
        }
        return two;
    }
}