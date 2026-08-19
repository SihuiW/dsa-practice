class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int res = 1;
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                cnt++;
            } else {
                cnt = 1;
            }

            res = Math.max(res, cnt);
        }

        return res;
    }
}