class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i]; 
        }
        int res = n + 1;
        for(int i = 0; i < n; i++) {
            int l = i, r = n;
            while(l < r) {
                int mid = l + (r - l) / 2;
                int curSum = preSum[mid + 1] - preSum[i];
                if(curSum >= target) {
                    res = Math.min(res, mid - i + 1);
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }



        return res == n + 1 ? 0: res;
    }
}