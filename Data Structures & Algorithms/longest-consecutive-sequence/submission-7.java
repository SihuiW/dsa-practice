class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 1;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int cnt = 1;
                int cur = n;

                while (set.contains(cur + 1)) {
                    cur++;
                    cnt++;
                }

                res = Math.max(res, cnt);
            }
        }

        return res;
    }
}