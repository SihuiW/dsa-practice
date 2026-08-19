class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int r1 = nums[0];
        int cur1 = nums[0];
        int total = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur1 = Math.max(nums[i], nums[i] + cur1);
            r1 = Math.max(r1, cur1);
            total += nums[i];
        }

        int r2 = nums[0];
        int cur2 = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur2 = Math.min(nums[i], nums[i] + cur2);
            r2 = Math.min(r2, cur2);
        }
        int r3 = total - r2;
        if (total == r2) return r1;
        return Math.max(r1, r3);

    }
}