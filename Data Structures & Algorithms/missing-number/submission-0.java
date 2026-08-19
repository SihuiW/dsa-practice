class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            sum += i;
        }
        sum += nums.length;
        return sum - total;
    }
}
