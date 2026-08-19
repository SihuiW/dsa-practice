class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return f(nums, target, 0, 0);
    }

    int f(int[] nums, int target, int idx, int total) {
        if(idx == nums.length) return total == target ? 1: 0;

        return f(nums, target, idx + 1, total + nums[idx]) +
            f(nums, target, idx + 1, total - nums[idx]);
    }
}