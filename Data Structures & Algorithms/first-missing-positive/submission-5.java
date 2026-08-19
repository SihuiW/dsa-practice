class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;
        for(int n: nums) {
            if(n == missing) {
                missing++;
            }
        }
        return missing;
    }
}