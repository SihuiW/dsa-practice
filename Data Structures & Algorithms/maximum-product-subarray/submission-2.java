class Solution {
    // dp[i...n]表示以i为结尾的字串最大乘积
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];

        for(int i = 1; i < n; i++) {
            int temp1 = Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]);
            int temp2 = Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]);

            max[i] = Math.max(temp1, nums[i]);
            min[i] = Math.min(temp2, nums[i]);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
