class Solution {
    // f我站在某一个点上 能否到达最后
    public boolean canJump(int[] nums) {
        return f(nums, 0);
    }

    boolean f(int[] nums, int index) {
        if(index >= nums.length - 1) return true;
        int range = nums[index];
        if(range == 0) return false;
        for(int i = range; i >= 1; i--) {
            if(f(nums, index + i)) return true;
        }
        return false;
    }
}
