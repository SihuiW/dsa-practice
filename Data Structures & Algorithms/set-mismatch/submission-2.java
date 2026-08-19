class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                res[0] = nums[i];
                break;
            }
        }
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int n : nums) actualSum += n;
        res[1] = expectedSum - (actualSum - res[0]);
        return res;
    }
}