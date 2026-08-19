class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int n: nums) {
            set.add(n);
        }
        for(int i = 0; i < nums.length; i++) {
            int times = 1;
            int index = 1;
            while(i < nums.length && set.contains(nums[i] + index)) {
                times++;
                index++;
            }
            res = Math.max(res, times);
        }
        return res;
    }
}
