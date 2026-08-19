class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        f(nums, target, 0, new ArrayList<>());
        return res;
    }

    void f(int[] nums, int target, int idx, List<Integer> list) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            if(nums[i] > target) return;
            if(target < 0) return;
            list.add(nums[i]);
            f(nums, target - nums[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
