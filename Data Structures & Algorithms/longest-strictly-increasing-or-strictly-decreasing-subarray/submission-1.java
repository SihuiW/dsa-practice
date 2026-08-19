class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxInc = 1;
        int maxDec = 1;
        int inc = 1;
        int dec = 1;

        if(nums.length == 1) return 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                inc++;
            } else {
                inc = 1;
            }
            maxInc = Math.max(maxInc, inc);
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                dec++;
            } else {
                dec = 1;
            }
            maxDec = Math.max(maxDec, dec);
        }
        return Math.max(maxInc, maxDec);
    }
}