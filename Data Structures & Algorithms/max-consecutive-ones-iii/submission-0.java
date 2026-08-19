class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int l = 0, r = 0;
        while(r < nums.length) {
            int n = nums[r];
            if(n == 0) k--;
            while(k < 0) {
                int nl = nums[l];
                if(nums[l] == 0) k++;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}