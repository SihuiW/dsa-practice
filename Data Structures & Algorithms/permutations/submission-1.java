class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length + 1];
        f(nums, new ArrayList<>(), used);
        return res;
    }

    void f(int[] nums, List<Integer> temp, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            f(nums, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
