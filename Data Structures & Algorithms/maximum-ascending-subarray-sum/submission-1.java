class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                sum += nums[i];
                res = Math.max(res, sum);
            } else {
                sum = nums[i];
            }
        }
        return res;
    }
}