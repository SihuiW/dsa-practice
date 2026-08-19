class Solution {
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        f(nums, 0, 0);
        return sum;
    }

    void f(int[] nums, int idx, int xor) {
        sum += xor;

        for (int i = idx; i < nums.length; i++) {
            f(nums, i + 1, xor ^ nums[i]);
        }
    }
}