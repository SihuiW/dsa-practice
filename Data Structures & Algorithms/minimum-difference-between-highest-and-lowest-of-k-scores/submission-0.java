class Solution {
    public int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int l = 0, r = k - 1;
        while(r < nums.length) {
            res = Math.min(res, nums[r++] - nums[l++]);
        }
        return res;

    }
}