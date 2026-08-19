class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        f(nums, new ArrayList<>());
        return res;
    }

    void f(int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            f(nums, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}