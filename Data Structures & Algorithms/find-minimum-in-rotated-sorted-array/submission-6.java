class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if(nums[mid] < nums[r]) {
                r = mid;
            } else if(nums[mid] > nums[l]) {
                l = mid + 1;
            } else if(l == r) {
                return nums[l];
            }
            
        }
        return nums[l];
    }
}
