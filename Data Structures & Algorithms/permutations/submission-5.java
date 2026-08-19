class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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
            if(used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            f(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
