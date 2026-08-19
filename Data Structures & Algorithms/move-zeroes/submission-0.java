class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while(r < nums.length) {
            if(nums[r] != 0) {
                nums[l] = nums[r];
                l++;

            }
            r++;
        }
        while(l < nums.length) {
            nums[l] = 0;
            l++;
        }
    }
}