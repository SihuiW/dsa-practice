class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 对于每一个数 要么加要么减
        // 所有数都选择合适的方式后 要达到target
        return f(nums, target, 0);
    }

    // 达到target的方式
    int f(int[] nums, int target, int index) {
        if(index == nums.length) {
            return target == 0 ? 1: 0;
        }

        int add = f(nums, target - nums[index], index + 1);
        int minus = f(nums, target + nums[index], index + 1);
        
        return add + minus;
    }
}
