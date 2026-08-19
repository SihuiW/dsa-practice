class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        res[0] = (l < nums.length && nums[l] == target) ? l : -1;
        l = 0;
        r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        res[1] = (r >= 0 && nums[r] == target) ? r : -1;
        return res;
    }
}