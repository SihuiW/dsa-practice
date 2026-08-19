class Solution {
    public boolean canJump(int[] nums) {
       int farthest = 0;
       int start = 0;
       while(start <= farthest) {
        farthest = Math.max(farthest, start + nums[start]);
        if(farthest >= nums.length - 1) return true;
        start++;
       }
       return false;
    }
}
