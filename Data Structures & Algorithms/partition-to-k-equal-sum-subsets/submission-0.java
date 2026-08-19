class Solution {
    boolean[] used;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length < k) return false;
        used = new boolean[nums.length];
        int total = 0;
        for(int i: nums) {
            total += i;
        }
        return f(nums, k, 0, total / k);
    }

    boolean f(int[] nums, int k, int curSum, int total) {
        if(k == 0) return true;
        if(curSum == total) {
            return f(nums, k - 1, 0, total);
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if(curSum + nums[i] > total) continue;
            used[i] = true;
            if(f(nums, k, curSum + nums[i], total)) return true;
            used[i] = false;
        }
        return false;

    }
}