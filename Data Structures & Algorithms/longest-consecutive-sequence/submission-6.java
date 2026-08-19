class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        int res = 1;
        int cnt = 1;
        int idx = 1;
        for(int n: nums) {
            while(set.contains(n + idx++)) {
                cnt++;
            }
            res = Math.max(res, cnt);
            cnt = 1;
            idx = 1;
        } 
        return res;
    }
}
