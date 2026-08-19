class Solution {
    int res = 0;

    public int subsetXORSum(int[] nums) {
        f(nums, 0, 0);
        return res;
    }

    void f(int[] nums, int index, int curXOR) {
        if(index >= nums.length) {
            res += curXOR;
            return;
        }
        f(nums, index + 1, curXOR);
        f(nums, index + 1, curXOR ^ nums[index]);
    }



    
}