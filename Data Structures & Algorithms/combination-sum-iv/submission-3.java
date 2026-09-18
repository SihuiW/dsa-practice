class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return f(nums, target, 0);
    }

    int f(int[] nums, int target, int cur) {
        if(cur == target) {
            return 1;
        }
        if(memo[cur] != -1) {
            return memo[cur];
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(cur + nums[i] > target) break;
            count += f(nums, target, cur + nums[i]);
        }
        return memo[cur] = count;
    }
}