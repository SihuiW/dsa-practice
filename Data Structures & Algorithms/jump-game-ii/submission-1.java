class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int start = 0;
        int end = 0;
        int far = 0;
        while(end < nums.length - 1) {
            while(start <= end) {
                far = Math.max(far, start + nums[start]);
                start++;
            }
            jump++;
            end = far;
        }
        return jump;
    }
}
