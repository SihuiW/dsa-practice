class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int n: nums) {
            l = Math.max(l, n);
            r += n;
        }
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(f(nums, mid) <= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
        
    }

    //分成多少个部分，能保证每个部分不超过mid
    int f(int[] nums, int need) {
        int part = 1;
        int sum = 0;
        for(int n: nums) {
            if(sum + n <= need) {
                sum += n;
            } else {
                part++;
                sum = n;
            }
        }
        return part;
    }
}