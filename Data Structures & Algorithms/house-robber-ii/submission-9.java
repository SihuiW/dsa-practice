class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int res1 = f(nums, 0, nums.length - 2);
        int res2 = f(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    private int f(int[] nums, int l, int r) {
        if(l == r) return nums[l];
        int one = nums[l];
        int two = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++) {
            int temp = Math.max(one + nums[i], two);
            one = two;
            two = temp;
        }
        return two;
    }
}
