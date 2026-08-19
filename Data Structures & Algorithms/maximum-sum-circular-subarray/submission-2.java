class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxCur = 0;
        int minCur = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = 0;

        for(int n: nums) {
            total += n;

            maxCur = Math.max(n, n + maxCur);
            maxSum = Math.max(maxSum, maxCur);

            minCur = Math.min(n, n + minCur);
            minSum = Math.min(minSum, minCur);

        }

        if(maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);

    }
}