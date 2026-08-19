class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int n: nums) total += n;
        int res = nums.length;
        int[] prefix = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < prefix.length; i++) {
            if(prefix[i] == total - nums[i] - prefix[i]) {
                res = Math.min(i, res);
            }
        }
        return res == nums.length? -1: res;
    }
}