class Solution {
    // 从start开始看 看看最远能到哪里
    // 在能到达的范围内 再去看最远
    // 直到这个超过或等于最后的位置
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        int far = 0;
        while(start <= end) {
            far = Math.max(far, start + nums[start]);
            if(far >= nums.length - 1) return true;
            end = far;
            start++;
        }
        return false;
    }
}
