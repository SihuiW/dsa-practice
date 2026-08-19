class Solution {
    public int firstMissingPositive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        for(int i = 1; i <= nums.length + 1; i++) {
            if(!set.contains(i)) {
                res = i;
                break;
            }
        }
        return res;

    }
}