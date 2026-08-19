class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int n: nums) {
            l = Math.max(l, n);
            r += n;
        }
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(f(nums, m) <= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    int f(int[] nums, int m) {
        int res = 1;
        int sum = 0;
        for(int n: nums) {
            if(sum + n > m) {
                res++;
                sum = n;
            } else {
                sum += n;
            }
        }
        return res;
    }
}