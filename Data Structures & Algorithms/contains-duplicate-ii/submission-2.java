class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();
        while(r < nums.length) {
            int rn = nums[r];
            if(set.contains(rn)) return true;
            set.add(rn);
            if(r - l >= k) {
                set.remove(nums[l]);
                l++;
            }
            r++;
        }
        return false;
    }
}