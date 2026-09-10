class Solution {
    public int rob(int[] nums) {
        int one = nums[0];
        if (nums.length == 1)
            return one;

        int two = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(two, one + nums[i]);
            one = two;
            two = temp;
        }
        return two;
    }
}
