class Solution {
    public int jump(int[] nums) {
        // 看一下从这个位置最大能到的范围是多少
        // 从这个范围里循环再次更新最大范围直到能覆盖到最后
        int jump = 0;
        int start = 0;      // 当前遍历的位置
        int end = 0;        // 当前层的结束位置
        int far = 0;        // 下一层能达到的最远位置
        while(start < nums.length - 1) {
            far = Math.max(far, start + nums[start]);
            if(start == end) {
                jump++;
                end = far;
            }
            start++;
        }
        return jump;
    }
}
