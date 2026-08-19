class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int n: nums) {
            set.add(n);
        }
        for(int i = 0; i < nums.length; i++) {
            int start = nums[i];
            if(!set.contains(start - 1)) {
                int cnt = 1;
                while(set.contains(start + 1)) {
                    cnt++;
                    start++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
