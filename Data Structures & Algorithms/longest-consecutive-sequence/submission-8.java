class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int n: nums) {
            set.add(n);
        }
        for(int n: nums) {
            if(set.contains(n - 1)) continue;
            int cnt = 1;
            while(true) {
                if(set.contains(n + 1)) {
                    cnt++;
                } else {
                    break;
                }
                n++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
