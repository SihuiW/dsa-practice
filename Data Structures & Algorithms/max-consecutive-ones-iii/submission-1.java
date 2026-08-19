class Solution {
    public int longestOnes(int[] nums, int k) {
        int window = 0;
        int l = 0, r = 0;
        int res = 0;
        while(r < nums.length) {
            int a = nums[r++];
            if(a == 1) window++;
            while(r - l - window > k) {
                int b = nums[l++];
                if(b == 1) window--;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}