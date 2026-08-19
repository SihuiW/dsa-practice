class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        f(nums, new ArrayList<>(), used);
        return res;
    }

    void f(int[] nums, List<Integer> list, boolean[] used) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if(used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            f(nums, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}