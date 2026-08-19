class Solution {
    // f我站在某一个点上 能否到达最后
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return f(nums, 0, memo);
    }

    boolean f(int[] nums, int index, Boolean[] memo) {
        if(index >= nums.length - 1) {
            return true;
        }
        if(memo[index] != null) return memo[index];
        int range = nums[index];
        if(range == 0) {
            memo[index] = false;
            return false;
        }
        for(int i = range; i >= 1; i--) {
            if(f(nums, index + i, memo)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }
}
