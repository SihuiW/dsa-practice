class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for(int n: nums) {
            if(n < cur) {
                continue;
            } else if (n > cur) {
                while (cur < n) {
                    res.add(cur++);
                }
            }
            cur++;
        }
        while (cur <= nums.length) {
            res.add(cur++);
        }
        return res;
    }
}