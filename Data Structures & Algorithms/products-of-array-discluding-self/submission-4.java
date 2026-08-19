class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        int prefix = 1;
        for(int i = 0; i < res.length; i++) {
            res[i] = res[i] * prefix;
            prefix *= nums[i];
        }
        return res;
    }
}  
