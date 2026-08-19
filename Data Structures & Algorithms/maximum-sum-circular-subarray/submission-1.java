class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // common
        // circle
        // 加起来大于0就要 小于0就从新的开始
        int sum1 = Integer.MIN_VALUE;
        int cur1 = 0;
        int sum2 = Integer.MAX_VALUE;
        int cur2 = 0;
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            cur1 = Math.max(nums[i], cur1 + nums[i]);
            cur2 = Math.min(nums[i], cur2 + nums[i]);

            sum1 = Math.max(sum1, cur1);
            sum2 = Math.min(sum2, cur2);
        }

        if (sum1 < 0) return sum1;

        return Math.max(sum1, total - sum2);


    }
}