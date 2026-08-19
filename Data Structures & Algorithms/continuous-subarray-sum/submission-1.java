class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 2; j < prefix.length; j++) {
                int sum = prefix[j] - prefix[i];

                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}