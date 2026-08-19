class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast) {
                return slow;
            }
        }
    }
}
